package com.lianyun.scan.model.abs;

import java.util.Date;

import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.model.Admin;
import com.lianyun.scan.util.json.strategy.ListHide;

public abstract class Check extends Name {

	/**
	 * 待审 or 已审
	 */
	private CheckStatus checkStatus = CheckStatus.SUCCESS;
	
	@ListHide
	private String reason;
	
	@ListHide
	@JsonAdapter(value = NameTypeAdapter.class)
	private Admin admin = new Admin();
	
	@ListHide
	private Date checkTime = new Date();

	
}
