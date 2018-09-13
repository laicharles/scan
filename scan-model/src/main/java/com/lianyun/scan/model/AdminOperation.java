package com.lianyun.scan.model;

import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.model.abs.Operation;

public class AdminOperation extends Operation {

	@JsonAdapter(value = NameTypeAdapter.class)
	private Admin admin = new Admin();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
