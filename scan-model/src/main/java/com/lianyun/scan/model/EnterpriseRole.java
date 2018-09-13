package com.lianyun.scan.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.frame.model.Switch;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.util.json.strategy.ListHide;

public class EnterpriseRole extends Name implements Switch {

	@Expose
	private String desc;

	@JsonAdapter(value = NameTypeAdapter.class)
	private Enterprise enterprise = new Enterprise();

	@Expose
	private boolean work = true;

	@Expose
	@ListHide
	@JsonAdapter(NameListTypeAdapter.class)
	private List<EnterpriseAuth> auths;

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<EnterpriseAuth> getAuths() {
		return auths;
	}

	public void setAuths(List<EnterpriseAuth> auths) {
		this.auths = auths;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

}
