package com.lianyun.scan.util;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.lianyun.scan.util.json.strategy.DateTypeAdapter;

public class JsonUtil {

	private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).serializeNulls()
			.create();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T fromJson(String json, Class<T> cls) {
		return gson.fromJson(json, cls);
	}

	public static <T> T fromJson(String json, Type typeOfT) {	
		return gson.fromJson(json, typeOfT);
	}
	
	public static <T> T fromJson(JsonElement json, Type typeOfT) {	
		return gson.fromJson(json, typeOfT);
	}

}
