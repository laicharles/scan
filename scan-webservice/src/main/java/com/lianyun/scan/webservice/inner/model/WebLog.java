package com.lianyun.scan.webservice.inner.model;

import java.util.Date;

import com.lianyun.scan.frame.model.WebModel;

public class WebLog extends WebModel {

	private Long id;

	private Date createTime;

	private String message;

	private String ip;

	private int platFormType;

	private Long eid;

	private Long operatorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPlatFormType() {
		return platFormType;
	}

	public void setPlatFormType(int platFormType) {
		this.platFormType = platFormType;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

}
