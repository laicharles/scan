package com.lianyun.scan.frame.model;

public class Work<K> implements Switch, IdAble<K>{

	private K id;
	private boolean work;

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

}
