package com.lianyun.scan.webservice.inner.model;

import java.util.Date;
import java.util.List;

import com.lianyun.scan.frame.model.WebModel;

public class WebEnterpriseRole extends WebModel {

	private Long id;

	private String name;

	private String desc;

	private boolean work;

	private List<Long> authIds;

	private long eid;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Long> getAuthIds() {
		return authIds;
	}

	public void setAuthIds(List<Long> authIds) {
		this.authIds = authIds;
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
