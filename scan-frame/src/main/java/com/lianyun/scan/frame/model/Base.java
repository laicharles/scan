package com.lianyun.scan.frame.model;

import java.util.Date;

import com.google.gson.annotations.Expose;

public abstract class Base implements IdAble<Long>{

	@Expose
	private Long id ;

	private Date createTime = new Date();

	private Date updateTime = new Date();

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
