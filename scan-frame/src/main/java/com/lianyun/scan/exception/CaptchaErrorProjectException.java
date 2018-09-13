package com.lianyun.scan.exception;

public class CaptchaErrorProjectException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return 104;
	}

	@Override
	public String getMessage() {
		return "图片验证码错误";
	}

}
