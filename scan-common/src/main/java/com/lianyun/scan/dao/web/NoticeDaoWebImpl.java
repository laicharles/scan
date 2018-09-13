package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Notice;
import com.lianyun.scan.webservice.inner.model.WebNotice;

@Repository
public class NoticeDaoWebImpl extends BaseDaoWebImpl<Long, Notice, WebNotice> {

	@Override
	protected WebNotice toOut0(Notice in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Notice toIn0(WebNotice out) {
		// TODO Auto-generated method stub
		return null;
	}

}
