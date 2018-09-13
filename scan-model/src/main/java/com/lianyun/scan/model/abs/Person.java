package com.lianyun.scan.model.abs;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.frame.model.Switch;
import com.lianyun.scan.util.json.strategy.Hide;
import com.lianyun.scan.util.json.strategy.ListHide;

public abstract class Person extends Name implements Switch {

	
	
	@Expose
	@ListHide
	private String tel;

	@Hide
	@Expose
	@ListHide
	private String password;

	@ListHide
	private String ip;

	@Expose
	@ListHide
	private String email;

	@Expose
	@ListHide
	private String desc;

	@Expose
	private boolean work = true;

	private Date loginTime = new Date();

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

}
