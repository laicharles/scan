package com.lianyun.scan.exception;

public class PasswordErrorProjectException extends AuthProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return 101;
	}

	@Override
	public String getMessage() {
		return "密码错误";
	}

}
