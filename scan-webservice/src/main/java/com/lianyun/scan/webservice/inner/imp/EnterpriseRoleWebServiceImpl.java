package com.lianyun.scan.webservice.inner.imp;

import org.springframework.stereotype.Component;

import com.lianyun.scan.frame.BaseWebServiceImpl;
import com.lianyun.scan.webservice.inner.model.WebEnterpriseRole;

@Component
public class EnterpriseRoleWebServiceImpl extends BaseWebServiceImpl<Long, WebEnterpriseRole> {

	@Override
	protected String host() {
		return "enterprises";
	}

	@Override
	protected String path() {
		return "v1/enterprises/{enterpriseId}/roles";
	}	

}
