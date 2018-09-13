package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Admin;
import com.lianyun.scan.webservice.inner.model.WebAdmin;

@Repository
public class AdminDaoWebImpl extends BaseDaoWebImpl<Long, Admin,WebAdmin> {

	@Override
	protected WebAdmin toOut0(Admin in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Admin toIn0(WebAdmin out) {
		// TODO Auto-generated method stub
		return null;
	}

}
