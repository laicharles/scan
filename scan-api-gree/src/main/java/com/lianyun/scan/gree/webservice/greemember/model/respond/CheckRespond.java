package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class CheckRespond {

	@SerializedName("Token")
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
