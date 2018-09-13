package com.lianyun.scan.exception;

//{
//    "code":0,
//    "error":"",
//    "data":null
//}
public class Result {

	private int code;
	private String error;
	private Object data;

	public Result(int code, String error, Object data) {
		super();
		this.code = code;
		this.error = error;
		this.data = data;
	}

	public Result(Object data) {
		this(0, "", data);
	}

	public Result() {
		this(null);
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
