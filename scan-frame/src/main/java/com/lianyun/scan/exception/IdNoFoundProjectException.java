package com.lianyun.scan.exception;

public class IdNoFoundProjectException extends ProjectException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNoFoundProjectException(Object id) {
		super("没找到对应id[" + id + "]对象");
	}

	@Override
	public int getCode() {
		return 404;
	}

}
