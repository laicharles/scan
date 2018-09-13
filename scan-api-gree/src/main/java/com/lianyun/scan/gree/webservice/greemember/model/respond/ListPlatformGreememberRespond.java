package com.lianyun.scan.gree.webservice.greemember.model.respond;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListPlatformGreememberRespond extends GreememberRespond<List<PlatformRespond>> {
	@SerializedName("Data")
	private List<PlatformRespond> data;

	public List<PlatformRespond> getData() {
		return data;
	}

	public void setData(List<PlatformRespond> data) {
		this.data = data;
	}

}
