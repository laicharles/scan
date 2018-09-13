package com.lianyun.scan.gree.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lianyun.scan.model.Kind;
import com.lianyun.scan.model.Subsystem;
import com.lianyun.scan.util.JsonUtil;

@Entity
@Table(name = "gree_kind")
public class GreeKind extends Kind {

	private Set<Long> subsystemIds ;
	
	@ElementCollection(fetch = FetchType.EAGER)
	public Set<Long> getSubsystemIds() {
		return subsystemIds;
	}

	public void setSubsystemIds(Set<Long> subsystemIds) {
		this.subsystemIds = subsystemIds;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

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

	
	public static void main(String[] args) {
		GreeKind kind = new GreeKind();
		ArrayList<Subsystem> subsystems = new ArrayList<>();
		subsystems.add(new Subsystem());
		subsystems.add(new Subsystem());
		kind.setSubsystems(subsystems );
		
		String json = JsonUtil.toJson(kind);
		
		System.out.println(json);
		
		Map map = JsonUtil.fromJson(json, Map.class);
		System.out.println(map);
		
		GreeKind kind2 = JsonUtil.fromJson(json, GreeKind.class);
		System.out.println(kind2);
	}
	
}
