package com.lianyun.scan.gree.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lianyun.scan.model.Employee;

@Entity
@Table(name = "gree_employee")
public class GreeEmployee extends Employee {

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Override
	public Date getCreateTime() {
		return super.getCreateTime();
	}

	@Override
	public void setCreateTime(Date createTime) {
		super.setCreateTime(createTime);
	}

	@Override
	public Date getUpdateTime() {
		return super.getUpdateTime();
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		super.setUpdateTime(updateTime);
	}

	@Override
	public String getIp() {
		return super.getIp();
	}

	@Override
	public void setIp(String ip) {
		super.setIp(ip);
	}

	@Override
	public Date getLoginTime() {
		return super.getLoginTime();
	}

	@Override
	public void setLoginTime(Date loginTime) {
		super.setLoginTime(loginTime);
	}

	@Override
	public boolean isWork() {
		return super.isWork();
	}

	@Override
	public void setWork(boolean work) {
		super.setWork(work);
	}

	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	

//  TODO 
//	@Override
//	public Set<EnterpriseRole> getRoles() {
//		return super.getRoles();
//	}
//
//	@Override
//	public void setRoles(Set<EnterpriseRole> roles) {
//		super.setRoles(roles);
//	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getTel() {
		return super.getTel();
	}

	@Override
	public void setTel(String tel) {
		super.setTel(tel);
	}

	private Set<Long> roleIds;

	@ElementCollection(fetch = FetchType.EAGER)
	public Set<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}

}
