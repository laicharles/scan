package com.lianyun.scan.webservice.inner.imp;

import org.springframework.stereotype.Component;

import com.lianyun.scan.frame.BaseWebServiceImpl;
import com.lianyun.scan.webservice.inner.model.WebEnterpriseContact;

@Component
public class EnterpriseContactWebServiceImpl extends BaseWebServiceImpl<Long, WebEnterpriseContact> {

	@Override
	protected String host() {
		return "enterprises";
	}

	@Override
	protected String path() {
		return "v1/enterprises/{enterpriseId}/concacts";
	}	

}
