package com.lianyun.scan.model.abs;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.lianyun.scan.frame.model.Name;

public class NameTypeAdapter extends TypeAdapter<Name> {

	@Override
	public void write(JsonWriter out, Name value) throws IOException {
		out.beginObject();
		out.name("id").value(value.getId());
		out.name("name").value(value.getName());
		out.endObject();

	}

	@Override
	public Name read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
