package com.lianyun.scan.webservice.inner.model;

import com.lianyun.scan.frame.model.WebModel;

public class WebCaptcha extends WebModel{

	private String code;

	private byte[] image;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
