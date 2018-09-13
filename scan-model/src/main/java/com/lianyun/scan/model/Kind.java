package com.lianyun.scan.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.model.abs.NameListTypeAdapter;

/**
 * 二级分类
 * 
 * @author 560133
 *
 */
public class Kind extends Name {

	private Long productCount = 0L;

	@Expose
	private String desc= "";

	//@Expose
	//@ListHide
	@JsonAdapter(NameListTypeAdapter.class)
	private ArrayList<Subsystem> subsystems = new ArrayList<>();

	public ArrayList<Subsystem> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(ArrayList<Subsystem> subsystems) {
		this.subsystems = subsystems;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
