package com.qing.core.utils;

import java.io.UnsupportedEncodingException;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @description 工程资源文件读取工具
 *
 * @author 谢进伟
 *
 * @createDate 2016-1-27 下午2:38:36
 */
public class PropertiesReadUtil extends PropertyPlaceholderConfigurer {

    private Logger log = Logger.getLogger(PropertiesReadUtil.class);
    private static Map<String , String> propertiesMap;
    private final String encoding = "UTF-8";

    /**
     * 读取工程所有资源文件
     */
    protected void processProperties(ConfigurableListableBeanFactory beanFactory , Properties props) {
        try {
            List<String> list = new ArrayList<String>();
            list.add("jdbc.username");
            list.add("jdbc.password");
            list.add("jdbc.url");
            decryptProperty(list , props);
        } catch (Exception e) {
            this.log.info("加密配置解密失败！");
            e.printStackTrace();
        }
        super.processProperties(beanFactory , props);
        propertiesMap = new HashMap<String , String>();
        Object key = null;
        String keyStr = null , value = null;
        for(Iterator<Object> localIterator = props.keySet().iterator() ; localIterator.hasNext() ;) {
            key = localIterator.next();
            keyStr = key.toString();
            value = props.getProperty(keyStr , "");
            try {
                value = new String(value.getBytes("ISO8859-1") , encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            propertiesMap.put(keyStr , value);
        }
    }

    /**
     * 相关加密资源值解密
     *
     * @param list
     *            需要解密的资源自key列表
     * @param props
     *            资源文件对象
     */
    private void decryptProperty(List<String> list , Properties props) {
        try {
            String modulus = props.getProperty("modulus");
            String private_exponent = props.getProperty("private_exponent");
            RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus , private_exponent);
            for(String key : list) {
                String mi_value = props.getProperty(key);
                String ming_value = RSAUtils.decryptByPrivateKey(mi_value , priKey);
                props.setProperty(key , ming_value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取资源值
     *
     * @param key
     *            资源值key
     * @return
     */
    public static String getContextProperty(String key) {
        return propertiesMap.get(key);
    }
}