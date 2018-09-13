package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class UserInfoGreememberRespond extends GreememberRespond<UserInfoRespond> {

	@SerializedName("Data")
	private UserInfoRespond data;

	public UserInfoRespond getData() {
		return data;
	}

	public void setData(UserInfoRespond data) {
		this.data = data;
	}

}
