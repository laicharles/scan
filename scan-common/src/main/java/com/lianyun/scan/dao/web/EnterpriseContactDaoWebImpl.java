package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.EnterpriseContact;
import com.lianyun.scan.webservice.inner.model.WebEnterpriseContact;

@Repository
public class EnterpriseContactDaoWebImpl extends BaseDaoWebImpl<Long, EnterpriseContact,WebEnterpriseContact> {

	@Override
	protected WebEnterpriseContact toOut0(EnterpriseContact in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EnterpriseContact toIn0(WebEnterpriseContact out) {
		// TODO Auto-generated method stub
		return null;
	}

}
