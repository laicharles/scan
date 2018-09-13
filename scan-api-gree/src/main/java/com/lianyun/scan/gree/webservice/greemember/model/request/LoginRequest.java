package com.lianyun.scan.gree.webservice.greemember.model.request;

import java.util.Base64;

import com.google.gson.annotations.SerializedName;

//{
//	"account":"13411558121",
//	"password":"MTIzNDU2",
//	"PlatformType":0
//	
//}
public class LoginRequest {

	@SerializedName("account")
	private String account;
	@SerializedName("password")
	private String password;
	@SerializedName("PlatformType")
	private int platformId;

	public LoginRequest(String account, String password, int platformId) {
		super();
		this.account = account;
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
		this.platformId = platformId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPlatformId() {
		return platformId;
	}

	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}

}
