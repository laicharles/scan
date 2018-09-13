package com.lianyun.scan.gree.webservice.greeimage.model.respond;

import java.util.List;

public class GreeimageCategory {

	private String name;
	private String code;
	private List<GreeimageCategory> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<GreeimageCategory> getChildren() {
		return children;
	}

	public void setChildren(List<GreeimageCategory> children) {
		this.children = children;
	}

}
