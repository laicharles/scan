package com.lianyun.scan.gree.webservice.greemember.model.request;

import com.google.gson.annotations.SerializedName;

public class CodeSignRequest extends TelSignRequest {

	public CodeSignRequest(String tel, String code) {
		super(tel);
		this.code = code;
	}

	@SerializedName("VCode")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
