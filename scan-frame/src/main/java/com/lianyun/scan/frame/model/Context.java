package com.lianyun.scan.frame.model;

import java.util.HashMap;
import java.util.Map;

public class Context {

	private Map<String, Object> params = new HashMap<>();

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
