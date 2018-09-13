package com.lianyun.scan.model;

import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.model.abs.Operation;

public class EnterpriseOperation extends Operation {

	@JsonAdapter(value = NameTypeAdapter.class)
	private Enterprise enterprise ;

	@JsonAdapter(value = NameTypeAdapter.class)
	private Employee employee;

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
