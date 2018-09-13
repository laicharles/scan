package com.lianyun.scan.frame.model;

import java.util.List;

public class Selector {

	private long id;
	private String name;

	private List<Selector> children;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Selector> getChildren() {
		return children;
	}

	public void setChildren(List<Selector> children) {
		this.children = children;
	}

}
