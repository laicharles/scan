package com.lianyun.scan.exception;

public abstract class ProjectException extends RuntimeException {

	public ProjectException() {
		super();
	}

	public ProjectException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract int getCode();

	public Result toResult() {
		Result result = new Result(getCode(), getMessage(), null);
		return result;
	}

}
