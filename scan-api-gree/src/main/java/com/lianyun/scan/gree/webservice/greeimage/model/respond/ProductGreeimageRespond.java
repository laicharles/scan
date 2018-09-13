package com.lianyun.scan.gree.webservice.greeimage.model.respond;

import java.util.Map;

public class ProductGreeimageRespond extends GreeimageRespond<Map<String, Object>> {

	private Map<String, Object> data;

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
