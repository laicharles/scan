package com.lianyun.scan.gree.webservice.greemember.model.request;

import java.util.Base64;

import com.google.gson.annotations.SerializedName;

//{
//	"Account":"15916321224",
//	"Timestamp":"1533537277618",
//	"Nonce":"123456",
//	"Signature":"0D3ECDB32549A8D3AC1836F705F119DB",
//	"Code":"9f5hh4",
//	"Password":"MTIzNDU2",
//	"Token":"18b23240-a2d4-4917-a472-6b7ca3be8577"
//}
public class ResetPasswordRequest extends AccountSignRequest {

	public ResetPasswordRequest(String account, String token, String code, String password) {
		super(account);
		this.token = token;
		this.code = code;
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
	}

	@SerializedName("Token")
	private String token;

	@SerializedName("Code")
	private String code;

	@SerializedName("Password")
	private String password;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
