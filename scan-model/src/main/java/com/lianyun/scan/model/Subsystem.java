package com.lianyun.scan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.frame.model.Switch;
import com.lianyun.scan.model.abs.NameTypeAdapter;
import com.lianyun.scan.util.json.strategy.ListHide;

/**
 * 子系统
 * 
 * @author 560133
 *
 */
public class Subsystem extends Name implements Switch{

	@Expose
	@ListHide
	private String logo;

	@Expose
	private String desc;

	@Expose
	@ListHide
	private String url;

	@Expose
	@ListHide
	private String healthUrl;

	@Expose
	@ListHide
	private String secretkey;

	@ListHide
	@JsonAdapter(value = NameTypeAdapter.class)
	private Enterprise owner;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHealthUrl() {
		return healthUrl;
	}

	public void setHealthUrl(String healthUrl) {
		this.healthUrl = healthUrl;
	}

	public String getSecretkey() {
		return secretkey;
	}

	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}

	public Enterprise getOwner() {
		return owner;
	}

	public void setOwner(Enterprise owner) {
		this.owner = owner;
	}

	@Expose
	private boolean work = true;
	
	@Override
	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

}
