package com.lianyun.scan.model.abs;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.util.JsonUtil;

public class NameListTypeAdapter implements JsonSerializer<List<Name>>, JsonDeserializer<List<? extends Name>> {

	@Override
	public JsonElement serialize(List<Name> src, Type typeOfSrc, JsonSerializationContext context) {
		JsonArray jsonMerchant = new JsonArray();

		for (Name name : src) {

			JsonObject element = new JsonObject();
			jsonMerchant.add(element);
			
			if(name!=null) {
				element.addProperty("id", name.getId());
				element.addProperty("name", name.getName());
			}
			
			
		}

		return jsonMerchant;
	}

	@Override
	public List<? extends Name> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return JsonUtil.fromJson(json, typeOfT);
	}
}
