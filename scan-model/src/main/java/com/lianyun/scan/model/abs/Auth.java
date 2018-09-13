package com.lianyun.scan.model.abs;

import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.util.json.strategy.ListHide;

public abstract class Auth extends Name {

	@ListHide
	private String refer;

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

}
