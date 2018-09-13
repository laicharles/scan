package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class LoginGreememberRespond extends GreememberRespond<LoginRespond> {

	@SerializedName("Data")
	private LoginRespond data;

	public LoginRespond getData()  {
		return data;
	}

	public void setData(LoginRespond data) {
		this.data = data;
	}

}
