package com.lianyun.scan.model.ad;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.model.UploadFile;
import com.lianyun.scan.util.json.strategy.ListHide;

public class Ad  extends Name{
	
	@Expose
	@ListHide
	private String link;
	
	@Expose
	@ListHide
	private int place=1;
	
	private boolean work;
	
	@Expose
	@ListHide
	private Date startTime = new Date();
	@Expose
	@ListHide
	private Date endTime = new Date();
	
	private AdStatus status = AdStatus.NORMAL;
	
	@Expose
	@ListHide
	private String source;
	
	@Expose
	@ListHide
	private List<UploadFile> pictures;


	
	
	

}
