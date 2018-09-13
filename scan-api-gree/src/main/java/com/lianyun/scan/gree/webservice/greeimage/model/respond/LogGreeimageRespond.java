package com.lianyun.scan.gree.webservice.greeimage.model.respond;

import java.util.List;

public class LogGreeimageRespond extends GreeimageRespond<List<GreeimageLog>> {

	private List<GreeimageLog> data;

	public List<GreeimageLog> getData() {
		return data;
	}

	public void setData(List<GreeimageLog> data) {
		this.data = data;
	}

}
