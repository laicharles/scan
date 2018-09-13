package com.lianyun.scan.gree.ad.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoDbImpl;
import com.lianyun.scan.gree.ad.dao.GreeAdDemoDao;
import com.lianyun.scan.gree.ad.model.GreeAdDemo;

@Repository
public class GreeAdDemoDaoImp extends BaseDaoDbImpl<Long, GreeAdDemo> implements GreeAdDemoDao {

	@Autowired
	private GreeAdDemoDao greeAdDemoDaoDbImpl;

	@Override
	public GreeAdDemo getByName(String name) {
		return greeAdDemoDaoDbImpl.getByName(name);
	}

}
