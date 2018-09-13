package com.lianyun.scan.util.json.strategy;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSelectOutUtil {

	private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter())
			.addSerializationExclusionStrategy(new HideStrategy(ListHide.class)).create();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

}
