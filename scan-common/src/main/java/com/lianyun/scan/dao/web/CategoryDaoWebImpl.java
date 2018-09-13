package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Category;
import com.lianyun.scan.webservice.inner.model.WebCategory;

@Repository
public class CategoryDaoWebImpl extends BaseDaoWebImpl<Long, Category,WebCategory> {

	@Override
	protected WebCategory toOut0(Category in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Category toIn0(WebCategory out) {
		// TODO Auto-generated method stub
		return null;
	}

}
