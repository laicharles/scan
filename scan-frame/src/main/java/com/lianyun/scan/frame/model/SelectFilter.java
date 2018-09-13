package com.lianyun.scan.frame.model;

public class SelectFilter {

	private long offset = 0;
	
	private long size = 10; 

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
