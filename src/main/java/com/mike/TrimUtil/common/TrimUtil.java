package com.mike.TrimUtil.common;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 将对象的字符串参数去掉头尾空格
 */
public class TrimUtil {
	private static Log log = LogFactory.getLog(TrimUtil.class);

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
								log.info("~~~~~~~~TrimUtil.trim~~~~~~~~~"+ e.getMessage(),e);
						    }
				        }	
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		
	}

}
