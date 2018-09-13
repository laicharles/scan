package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class CheckGreememberRespond extends GreememberRespond<CheckRespond> {

	@SerializedName("Data")
	private CheckRespond data;

	public CheckRespond getData() {
		return data;
	}

	public void setData(CheckRespond data) {
		this.data = data;
	}

}
