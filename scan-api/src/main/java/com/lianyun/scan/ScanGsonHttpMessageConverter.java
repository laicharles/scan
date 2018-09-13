package com.lianyun.scan;

import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Date;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.lang.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lianyun.scan.exception.Result;
import com.lianyun.scan.frame.model.Page;
import com.lianyun.scan.util.json.strategy.DateTypeAdapter;
import com.lianyun.scan.util.json.strategy.Hide;
import com.lianyun.scan.util.json.strategy.HideStrategy;
import com.lianyun.scan.util.json.strategy.ListHide;

public class ScanGsonHttpMessageConverter extends GsonHttpMessageConverter {

	private Gson gson4Obj = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter())
			.addSerializationExclusionStrategy(new HideStrategy(Hide.class)).serializeNulls().create();

	private Gson gson4Page = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter())
			.addSerializationExclusionStrategy(new HideStrategy(ListHide.class)).serializeNulls().create();

	public Gson getGson(Object o) {
		if (o == null) {
			return this.gson4Obj;
		}

		if (o instanceof Result) {
			Result r = (Result) o;
			Object d = r.getData();
			if (d != null && d instanceof Page) {
				return this.gson4Page;
			}

		}

		return this.gson4Obj;
	}

	@Override
	protected void writeInternal(Object o, @Nullable Type type, Writer writer) throws Exception {
//		if (type instanceof ParameterizedType) {
//			getGson(o).toJson(o, type, writer);
//		} else {
//			getGson(o).toJson(o, writer);
//		}
		
		getGson(o).toJson(o, writer);
	}

}
