package com.lianyun.scan.util.json.strategy;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonInUtil {

	private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).excludeFieldsWithoutExposeAnnotation().serializeNulls().create();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

}
