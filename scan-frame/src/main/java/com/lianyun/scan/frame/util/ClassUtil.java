package com.lianyun.scan.frame.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtil {

	public static List<Field> getAllFields(Class<?> cls) {

		List<Field> fields = new ArrayList<>();
		Class<?> tempClass = cls;
		while (tempClass != null) {// 当父类为null的时候说明到达了最上层的父类(Object类).
			fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass(); // 得到父类,然后赋给自己
		}
		return fields;
	}

}
