package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Product;
import com.lianyun.scan.webservice.inner.model.WebProduct;

@Repository
public class ProductDaoWebImpl extends BaseDaoWebImpl<Long, Product, WebProduct> {

	@Override
	protected WebProduct toOut0(Product in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Product toIn0(WebProduct out) {
		// TODO Auto-generated method stub
		return null;
	}

}
