package com.lianyun.scan.webservice.inner.imp;

import org.springframework.stereotype.Component;

import com.lianyun.scan.frame.BaseWebServiceImpl;
import com.lianyun.scan.webservice.inner.model.WebKind;

@Component
public class KindWebServiceImpl extends BaseWebServiceImpl<Long, WebKind> {

	@Override
	protected String host() {
		return "10.2.46.210:8084";
	}

	@Override
	protected String path() {
		return "v1/enterprises/{enterpriseId}/secondaryClasses";
	}	

}
