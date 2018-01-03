package com.qing.core.utils;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: RSA加解密工具
 * @author 谢进伟
 * @date 2015-10-12 下午2:58:27
 */
public class RSAUtils {

    /**
     * 公钥
     */
    private final static String publicKeyStr = "publicKey";
    private final static String privateKeyStr = "privateKey";

    /**
     * 生成公钥和私钥
     *
     * @throws NoSuchAlgorithmException
     *
     */
    private static HashMap<String , Object> generateKeys() throws NoSuchAlgorithmException {
        HashMap<String , Object> map = new HashMap<String , Object>();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
        map.put(publicKeyStr , publicKey);
        map.put(privateKeyStr , privateKey);
        return map;
    }

    /**
     * @param generateKeys
     * @return 获取 publicKey 值
     * @throws NoSuchAlgorithmException
     */
    public static RSAPublicKey getPublicKey(HashMap<String , Object> generateKeys) throws NoSuchAlgorithmException {
        return (RSAPublicKey)generateKeys.get(publicKeyStr);
    }

    /**
     * @param generateKeys
     * @return 获取 privateKey 值
     * @throws NoSuchAlgorithmException
     */
    public static RSAPrivateKey getPrivateKey(HashMap<String , Object> generateKeys) throws NoSuchAlgorithmException {
        return (RSAPrivateKey)generateKeys.get(privateKeyStr);
    }

    /**
     * 使用模和指数生成RSA公钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus
     *            模
     * @param exponent
     *            指数
     * @return
     */
    public static RSAPublicKey getPublicKey(String modulus , String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1 , b2);
            return (RSAPublicKey)keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用模和指数生成RSA私钥
     * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
     * /None/NoPadding】
     *
     * @param modulus
     *            模
     * @param exponent
     *            指数
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String modulus , String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1 , b2);
            return (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公钥加密
     *
     * @param data
     *            需要加密的数据
     * @param publicKey
     *            公钥
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data , RSAPublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE , publicKey);
        // 模长
        int key_len = publicKey.getModulus().bitLength() / 8;
        // 加密数据长度 <= 模长-11
        String [] datas = splitString(data , key_len - 11);
        String mi = "";
        // 如果明文长度大于模长-11则要分组加密
        for(String s : datas) {
            mi += bcd2Str(cipher.doFinal(s.getBytes()));
        }
        return mi;
    }

    /**
     * 私钥解密
     *
     * @param data
     *            需要解密的数据
     * @param privateKey
     *            私钥
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data , RSAPrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE , privateKey);
        // 模长
        int key_len = privateKey.getModulus().bitLength() / 8;
        byte [] bytes = data.getBytes();
        byte [] bcd = ASCII_To_BCD(bytes , bytes.length);
        // 如果密文长度大于模长则要分组解密
        String ming = "";
        byte [][] arrays = splitArray(bcd , key_len);
        for(byte [] arr : arrays) {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }

    /**
     * ASCII码转BCD码
     *
     */
    public static byte [] ASCII_To_BCD(byte [] ascii , int asc_len) {
        byte [] bcd = new byte [asc_len / 2];
        int j = 0;
        for(int i = 0 ; i < (asc_len + 1) / 2 ; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte)(((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public static byte asc_to_bcd(byte asc) {
        byte bcd;

        if((asc >= '0') && (asc <= '9'))
            bcd = (byte)(asc - '0');
        else if((asc >= 'A') && (asc <= 'F'))
            bcd = (byte)(asc - 'A' + 10);
        else if((asc >= 'a') && (asc <= 'f'))
            bcd = (byte)(asc - 'a' + 10);
        else
            bcd = (byte)(asc - 48);
        return bcd;
    }

    /**
     * BCD转字符串
     */
    public static String bcd2Str(byte [] bytes) {
        char temp[] = new char [bytes.length * 2] , val;

        for(int i = 0 ; i < bytes.length ; i++) {
            val = (char)(((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char)(val > 9 ? val + 'A' - 10 : val + '0');

            val = (char)(bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char)(val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串
     */
    public static String [] splitString(String string , int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if(y != 0) {
            z = 1;
        }
        String [] strings = new String [x + z];
        String str = "";
        for(int i = 0 ; i < x + z ; i++) {
            if(i == x + z - 1 && y != 0) {
                str = string.substring(i * len , i * len + y);
            } else {
                str = string.substring(i * len , i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 拆分数组
     */
    public static byte [][] splitArray(byte [] data , int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if(y != 0) {
            z = 1;
        }
        byte [][] arrays = new byte [x + z] [];
        byte [] arr;
        for(int i = 0 ; i < x + z ; i++) {
            arr = new byte [len];
            if(i == x + z - 1 && y != 0) {
                System.arraycopy(data , i * len , arr , 0 , y);
            } else {
                System.arraycopy(data , i * len , arr , 0 , len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    public static void main(String [] args) throws Exception {
        // 明文
        Map<String, String> map_org = new TreeMap<String, String>();
        // //////////////////////////////开发环境////////////////////////////////////////
        System.out.println("开发环境");
        map_org.put("jdbc.username" , "root");
        map_org.put("jdbc.password" , "123456");
        map_org.put("jdbc.url" , "jdbc:mysql://127.0.0.1:3306/ti?useUnicode=true&characterEncoding=UTF-8");
        //
        // map_org.put("hds.jdbc.username" , "sa");
        // map_org.put("hds.jdbc.password" , "dyrsit247");
        // map_org.put("hds.jdbc.url" ,
        // "jdbc:jtds:sqlserver://192.168.0.216:1433;DatabaseName=dyrs_erp;");

        // //////////////////////////////生产环境////////////////////////////////////////
//		System.out.println("生产环境");
//		map_org.put("jdbc.username", "root");
//		map_org.put("jdbc.password", "123456");
//		map_org.put("jdbc.url", "jdbc:mysql://localhost:3306/ti?useUnicode=true&characterEncoding=UTF-8");

        // //////////////////////////////测试环境////////////////////////////////////////
//		System.out.println("测试环境");
//		map_org.put("jdbc.username" , "root");
//		map_org.put("jdbc.password" , "ti@2016");
//		map_org.put("jdbc.url" ,"jdbc:mysql://172.16.105.114:3306/ti?useUnicode=true&characterEncoding=UTF-8");
        //
        // map_org.put("hds.jdbc.username" , "sa");
        // map_org.put("hds.jdbc.password" , "dyrsit247");
        // map_org.put("hds.jdbc.url" ,
        // "jdbc:jtds:sqlserver://192.168.0.216:1433;DatabaseName=dyrs_erp;");

        // 生成公钥和私钥
        HashMap<String, Object> generateKeys = RSAUtils.generateKeys();
        RSAPublicKey publicKey = RSAUtils.getPublicKey(generateKeys);
        RSAPrivateKey privateKey = RSAUtils.getPrivateKey(generateKeys);
        // 模
        String modulus = publicKey.getModulus().toString();
        // 公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        // 私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        // 使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        // RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus ,
        // private_exponent);
        System.out.println("modulus=" + modulus);
        System.out.println("public_exponent=" + public_exponent);
        System.out.println("private_exponent=" + private_exponent);
        // 加密后的密文
        Iterator<String> iterator = map_org.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String mi_value = RSAUtils.encryptByPublicKey(map_org.get(key), pubKey);
            System.out.println(key + " = " + mi_value);
            // String ming_value = RSAUtils.decryptByPrivateKey(mi_value ,
            // priKey);
            // System.out.println(key + "解密后:" + ming_value);
        }
    }
}
