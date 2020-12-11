package com.github.mikeliyes.TrimUtil;

import java.lang.reflect.Field;


/**
 * 将对象的字符串参数去掉头尾空格
 */
public class TrimUtil {

	/**
	 * 将对象的字符串参数去掉头尾空格
	 * @param args
	 * @return
	 */
	public static void trim(Object args) {
		
		Class clazz = args.getClass();
		Field[]	fields = clazz.getDeclaredFields();
		
		if (fields == null || fields.length == 0) {
			return;
		}
		
		for (Field field : fields) {
			if (field != null) {
				Class fClazz = field.getType();
				if (fClazz!=null 
						&& fClazz.getName() != null 
						&& !fClazz.getName().trim().equalsIgnoreCase("")
						&& "java.lang.String".equalsIgnoreCase(fClazz.getName())) {
					
							try {
								field.setAccessible(true);
								Object value = field.get(args);
								if (value != null && value instanceof String) {
									String val = String.valueOf(value);
									if (val != null 
											&& !val.trim().equalsIgnoreCase("")) {
										field.set(args, val.trim());
									}
								}
							} catch (Exception e) {
						    }
				        }	
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		
	}

}
