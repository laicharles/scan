package com.lianyun.scan.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.model.abs.Check;
import com.lianyun.scan.model.abs.NameListTypeAdapter;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.model.abs.Param;
import com.lianyun.scan.util.json.strategy.ListHide;

public class Product extends Check {

	@JsonAdapter(value = NameTypeAdapter.class)
	private Enterprise enterprise = new Enterprise();

	@Expose
	@JsonAdapter(value = NameTypeAdapter.class)
	private Kind kind = new Kind();

	@Expose
	@ListHide
	private String model;

	@Expose
	@ListHide
	private String desc;

	@Expose
	@ListHide
	private String link;

	/**
	 * 介绍
	 */
	@Expose
	@ListHide
	private UploadFile introduce = new UploadFile();

	/**
	 * 产品参数
	 */
	@Expose
	@ListHide
	private List<Param> params;

	private String previewUrl;

	/**
	 * 说明书
	 */
	@Expose
	@ListHide
	private UploadFile instructions = new UploadFile();

	@Expose
	private List<UploadFile> pictures;

	@Expose
	@ListHide
	@JsonAdapter(value = NameListTypeAdapter.class)
	private List<Product> recommendProducts;

	@Expose
	@ListHide
	@JsonAdapter(value = NameListTypeAdapter.class)
	private List<Subsystem> subsystems;

}
