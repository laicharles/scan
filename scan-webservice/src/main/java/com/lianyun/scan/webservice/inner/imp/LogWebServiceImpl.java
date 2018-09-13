package com.lianyun.scan.webservice.inner.imp;

import org.springframework.stereotype.Component;

import com.lianyun.scan.frame.BaseWebServiceImpl;
import com.lianyun.scan.webservice.inner.model.WebLog;

@Component
public class LogWebServiceImpl extends BaseWebServiceImpl<Long, WebLog> {

	@Override
	protected String host() {
		return "log";
	}

	@Override
	protected String path() {
		return "v1/logs";
	}	
	
}
