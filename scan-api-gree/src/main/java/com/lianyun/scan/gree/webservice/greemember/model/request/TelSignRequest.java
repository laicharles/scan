package com.lianyun.scan.gree.webservice.greemember.model.request;

import com.google.gson.annotations.SerializedName;

public class TelSignRequest extends SignRequest {

	@SerializedName("Telphone")
	private String tel;

	public TelSignRequest(String tel) {
		super(tel);
		this.tel = tel;
	}

}
