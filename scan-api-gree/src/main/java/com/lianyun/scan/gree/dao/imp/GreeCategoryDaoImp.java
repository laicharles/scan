package com.lianyun.scan.gree.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoDbImpl;
import com.lianyun.scan.gree.dao.GreeCategoryDao;
import com.lianyun.scan.gree.model.GreeCategory;

@Repository
public class GreeCategoryDaoImp extends BaseDaoDbImpl<Long, GreeCategory> implements GreeCategoryDao {

	@Autowired
	private GreeCategoryDao greeCategoryDaoDbImpl;
	
	@Override
	public GreeCategory getByCode(String code) {
		return greeCategoryDaoDbImpl.getByCode(code);
	}

}
