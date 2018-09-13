package com.lianyun.scan.util.json.strategy;

import java.lang.annotation.Annotation;
import java.util.Collection;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class HideStrategy implements ExclusionStrategy {

	private Class<?> hide;

	public HideStrategy(Class<?> hide) {
		super();
		this.hide = hide;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes fieldAttributes) {
		Collection<Annotation> annotations = fieldAttributes.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(hide)) {
				return true;
			}
		}
		return false;
	}

}
