package com.lianyun.scan.frame.model;

public class Count {

	@Header("Count")
	private long count;

	@Header("Content-Type")
	private String contentType;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
