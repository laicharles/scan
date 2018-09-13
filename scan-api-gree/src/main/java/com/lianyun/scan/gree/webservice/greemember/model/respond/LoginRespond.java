package com.lianyun.scan.gree.webservice.greemember.model.respond;

import com.google.gson.annotations.SerializedName;

public class LoginRespond {
	@SerializedName("Exp")
	private long exp;
	@SerializedName("Token")
	private String token;
	@SerializedName("RefreshToken")
	private String refreshToken;
	@SerializedName("Refresh_exp")
	private long refreshExp;
	@SerializedName("Timeout")
	private long timeout;
	@SerializedName("Uint")
	private String unit;
	@SerializedName("UserID")
	private long userId;

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public long getRefreshExp() {
		return refreshExp;
	}

	public void setRefreshExp(long refreshExp) {
		this.refreshExp = refreshExp;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
