package com.lianyun.scan.gree.webservice.greemember.model.request;

public class ForgetPasswordCodeSignRequest extends AccountSignRequest {

	public ForgetPasswordCodeSignRequest(String tel, String token) {
		super(tel);
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
