package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.webservice.inner.model.WebEnterprise;

@Repository
public class EnterpriseDaoWebImpl extends BaseDaoWebImpl<Long, Enterprise,WebEnterprise> {

	@Override
	protected WebEnterprise toOut0(Enterprise in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Enterprise toIn0(WebEnterprise out) {
		// TODO Auto-generated method stub
		return null;
	}

}
