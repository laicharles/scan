package com.lianyun.scan.exception;

public class NoPowerProjectException extends AuthProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return 103;
	}

	@Override
	public String getMessage() {
		return "无权访问";
	}

}
