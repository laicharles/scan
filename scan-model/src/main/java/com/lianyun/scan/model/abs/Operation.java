package com.lianyun.scan.model.abs;

import com.lianyun.scan.frame.model.Base;

/**
 * 操作
 * 
 * @author 560133
 *
 */
public abstract class Operation extends Base {

	private String ip ;

	private String message ;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
