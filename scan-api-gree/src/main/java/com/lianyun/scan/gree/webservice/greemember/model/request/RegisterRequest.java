package com.lianyun.scan.gree.webservice.greemember.model.request;

import java.util.Base64;

import com.google.gson.annotations.SerializedName;

//{
//	"Account":"15916321224",
//	"Telphone":"15916321224",
//	"Password":"MTIzNDU2",
//	"Timestamp":"1533537277618",
//	"Nonce":"123456",
//	"Signature":"0D3ECDB32549A8D3AC1836F705F119DB",
//  "VCode":"1234",
//	"PlatformType":0
//	
//}
public class RegisterRequest extends TelSignRequest {

	public RegisterRequest(String tel, String password, String code, int platformId) {
		super(tel);
		this.account = tel;
		this.code = code;
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
		this.platformId = platformId;

	}

	@SerializedName("VCode")
	private String code;

	@SerializedName("account")
	private String account;
	@SerializedName("password")
	private String password;
	@SerializedName("PlatformType")
	private int platformId;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
