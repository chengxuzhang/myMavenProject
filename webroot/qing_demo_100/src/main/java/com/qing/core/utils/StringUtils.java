package com.qing.core.utils;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

/**
 * @description 字符串操作工具(扩展自org.apache.commons.lang.StringUtils)
 * 
 * @author 谢进伟
 * 
 * @createDate 2016-2-19 下午00:36:43
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	/**
	 * 将字符串根据java变量规则(驼峰式)进行格式化
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @return
	 */
	public static String converToJavaField(String str) {
		return StringUtils.converToJavaVariable(str , true);
	}
	
	/**
	 * 将字符串根据java变量规则(驼峰式)进行格式化
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @param firstChatIsLower
	 *            首字母是否小写
	 * @return
	 */
	public static String converToJavaVariable(String str , boolean firstChatIsLower) {
		List<Character> list = new ArrayList<Character>();
		char [] numberChars = {'1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9' , '0'};
		int length = str.length();
		for(int i = 0 ; i < length ; i++) {
			char c = str.charAt(i);
			if(i == 0) {
				if(c == '_') {
					if(firstChatIsLower) {
						list.add(Character.toLowerCase(str.charAt(++i)));
					} else {
						list.add(Character.toUpperCase(str.charAt(++i)));
					}
				} else if(ArrayUtils.contains(numberChars , c)) {
					list.add('_');
					if(firstChatIsLower) {
						list.add(Character.toLowerCase(c));
					} else {
						list.add(Character.toUpperCase(c));
					}
				} else {
					if(firstChatIsLower) {
						list.add(Character.toLowerCase(c));
					} else {
						list.add(Character.toUpperCase(c));
					}
				}
			} else if(c != '_') {
				list.add(c);
			} else {
				if(i != length - 1) {
					Character c1 = str.charAt(++i);
					list.add(Character.toUpperCase(c1));
				}
			}
		}
		String newStr = StringUtils.join(list , "");
		return newStr;
	}
	
	/**
	 * 根据javaBean标准获取一个属性对应的getter/setter的后缀
	 * 
	 * @param fileName
	 *            属性名称
	 */
	public static String getGetterOrSetterSuffix(String fileName) {
		if(isBlank(fileName)) {
			return null;
		}
		if(fileName.length() == 1) {
			return fileName.toUpperCase();
		} else {
			char firstChart = fileName.charAt(0);
			char secondChart = fileName.charAt(1);
			if((secondChart > 'A' && secondChart < 'Z') || (firstChart > 'A' && firstChart < 'Z')) {
				return fileName;
			} else {
				return converToJavaVariable(fileName , false);
			}
		}
	}
}
