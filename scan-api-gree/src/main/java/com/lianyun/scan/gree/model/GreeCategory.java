package com.lianyun.scan.gree.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Children;
import com.lianyun.scan.model.Category;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.util.json.strategy.ListHide;

@Entity
@Table(name = "gree_category")
public class GreeCategory extends Category {

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ListHide
	@JsonAdapter(NameListTypeAdapter.class)
	@Children
	private List<GreeKind> greeKinds;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	@OrderColumn(name = "no")
	public List<GreeKind> getGreeKinds() {
		return greeKinds;
	}

	public void setGreeKinds(List<GreeKind> greeKinds) {
		this.greeKinds = greeKinds;
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

}
