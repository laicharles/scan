package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Kind;
import com.lianyun.scan.webservice.inner.model.WebKind;

@Repository
public class KindDaoWebImpl extends BaseDaoWebImpl<Long, Kind, WebKind> {

	@Override
	protected WebKind toOut0(Kind in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Kind toIn0(WebKind out) {
		// TODO Auto-generated method stub
		return null;
	}

}
