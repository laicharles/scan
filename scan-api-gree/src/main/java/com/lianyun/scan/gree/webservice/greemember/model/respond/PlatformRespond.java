package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class PlatformRespond {
	@SerializedName("Index")
	private int index;
	@SerializedName("Name")
	private String name;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
