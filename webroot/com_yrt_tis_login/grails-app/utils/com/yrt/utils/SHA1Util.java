/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 *
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.yrt.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * @description SHA1加密工具
 *
 * @author 谢进伟
 *
 * @createDate 2016年9月20日 下午3:17:32
 */
public class SHA1Util {

    /**
     * 对指定字符串进行Sha1签名
     *
     * @param str
     *            需要签名的字符串
     * @return
     */
    public static String sha1(String str) {
        String signature = "";
        if(str == null || str.length() == 0) {
            return null;
        }
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return signature;
    }

    /**
     * 将一个字节数组转换成十六进制字符串
     *
     * @param hash
     *            字节数组
     * @return
     */
    public static String byteToHex(final byte [] hash) {
        Formatter formatter = new Formatter();
        for(byte b : hash) {
            formatter.format("%02x" , b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    public static void main(String [] args) {
        String sha1 = sha1("40280981582deed501582dfc94a40000"+"123456"+"2016-11-04 14:17:58.0");
        System.out.println(sha1);
    }
}
