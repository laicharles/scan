package com.lianyun.scan.exception;

public class NoLoginProjectException extends AuthProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return 102;
	}

	@Override
	public String getMessage() {
		return "登录过期，重新登录";
	}

}
