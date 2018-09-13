package com.lianyun.scan.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.model.abs.Person;

/**
 * 管理账号
 * 
 * @author 560133
 *
 */
public class Admin extends Person { 

	@JsonAdapter(NameListTypeAdapter.class)
	private List<AdminAuth> auths;

	{
		auths = new ArrayList<>();
		auths.add(new AdminAuth());
		auths.add(new AdminAuth());
		auths.add(new AdminAuth());
	}

	public List<AdminAuth> getAuths() {
		return auths;
	}

	public void setAuths(List<AdminAuth> auths) {
		this.auths = auths;
	}

}
