package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;
import com.lianyun.scan.exception.BusinessProjectException;

public abstract class GreememberRespond<T> {
	@SerializedName("Code")
	private int code;
	@SerializedName("Error")
	private String error;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	protected abstract T getData();

	public final T getRealData() {

		if (code != 0) {
			throw new BusinessProjectException(error);
		}

		return getData();
	}

}
