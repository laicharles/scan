package com.lianyun.scan.exception;

public class BusinessProjectException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessProjectException() {
		super();
	}

	public BusinessProjectException(String message) {
		super(message);
	}

	@Override
	public int getCode() {
		return 4;
	}

}
