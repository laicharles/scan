package com.lianyun.scan.gree.webservice.greemember.model.respond;

public class UserLogin {

	private boolean change;

	private LoginRespond loginRespond;

	public LoginRespond getLoginRespond() {
		return loginRespond;
	}

	public void setLoginRespond(LoginRespond loginRespond) {
		this.loginRespond = loginRespond;
	}

	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		this.change = change;
	}

}
