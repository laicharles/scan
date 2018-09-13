package com.lianyun.scan.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.model.abs.Person;
import com.lianyun.scan.util.json.strategy.Hide;
import com.lianyun.scan.util.json.strategy.ListHide;

/**
 * 企业账号
 * 
 * @author 560133
 *
 */
public class Employee extends Person {

	@Hide
	@ListHide
	@JsonAdapter(value = NameTypeAdapter.class)
	private Enterprise enterprise;

	@Expose
	@JsonAdapter(value = NameListTypeAdapter.class)
	private List<EnterpriseRole> roles;

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<EnterpriseRole> getRoles() {
		return roles;
	}

	public void setRoles(List<EnterpriseRole> roles) {
		this.roles = roles;
	}

}
