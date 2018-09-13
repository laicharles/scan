package com.lianyun.scan.frame.model;

import com.google.gson.annotations.Expose;

public abstract class Name extends Base {

	@Expose
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
