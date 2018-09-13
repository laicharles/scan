package com.lianyun.scan.gree.webservice.greemember.model.request;

import com.google.gson.annotations.SerializedName;
import com.lianyun.scan.exception.BusinessProjectException;
import com.lianyun.scan.util.RandomUtil;

public abstract class SignRequest {

	@SerializedName("Timestamp")
	private String timestamp;

	@SerializedName("Signature")
	private String signature;

	@SerializedName("Nonce")
	private String nonce;

	public SignRequest(String telOrAccount) {
		super();
		this.nonce = RandomUtil.randomString(16);
		this.timestamp = System.currentTimeMillis() + "";

		try {
			this.signature = GreememberSignatureUtil.getSign(telOrAccount, timestamp, nonce);
		} catch (Exception e) {
			throw new BusinessProjectException(e.getMessage());
		}
	}

}
