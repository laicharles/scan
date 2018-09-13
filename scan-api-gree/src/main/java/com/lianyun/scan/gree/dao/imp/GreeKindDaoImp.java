package com.lianyun.scan.gree.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoDbImpl;
import com.lianyun.scan.gree.dao.GreeKindDao;
import com.lianyun.scan.gree.model.GreeKind;

@Repository
public class GreeKindDaoImp extends BaseDaoDbImpl<Long, GreeKind> implements GreeKindDao {

	@Autowired
	private GreeKindDao greeKindDaoDbImpl;

	@Override
	public GreeKind getByCode(String code) {
		return greeKindDaoDbImpl.getByCode(code);
	}

}
