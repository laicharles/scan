package com.lianyun.scan.gree.webservice.greeimage.model.respond;

import java.util.List;

public class CategoryGreeimageRespond extends GreeimageRespond<List<GreeimageCategory>> {

	private List<GreeimageCategory> data;

	public List<GreeimageCategory> getData() {
		return data;
	}

	public void setData(List<GreeimageCategory> data) {
		this.data = data;
	}

}
