package com.lianyun.scan.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.util.json.strategy.ListHide;

/**
 * 一级分类
 * 
 * @author 560133
 *
 */
public class Category extends Name {

	private Long productCount = 0L;

	@Expose
	private String desc = "";

	@ListHide
	@JsonAdapter(NameListTypeAdapter.class)
	private List<Kind> kinds;

	public List<Kind> getKinds() {
		return kinds;
	}

	public void setKinds(List<Kind> kinds) {
		this.kinds = kinds;
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
