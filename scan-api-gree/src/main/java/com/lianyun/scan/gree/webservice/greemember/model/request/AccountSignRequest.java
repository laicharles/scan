package com.lianyun.scan.gree.webservice.greemember.model.request;

import com.google.gson.annotations.SerializedName;

public class AccountSignRequest extends SignRequest {

	@SerializedName("Account")
	private String account;

	public AccountSignRequest(String account) {
		super(account);
		this.account = account;
	}

}
