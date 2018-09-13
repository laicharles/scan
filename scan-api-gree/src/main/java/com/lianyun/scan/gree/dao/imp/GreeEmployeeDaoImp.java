package com.lianyun.scan.gree.dao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoDbImpl;
import com.lianyun.scan.gree.dao.GreeEmployeeDao;
import com.lianyun.scan.gree.model.GreeEmployee;

@Repository
public class GreeEmployeeDaoImp extends BaseDaoDbImpl<Long, GreeEmployee> implements GreeEmployeeDao {

	@Autowired
	private GreeEmployeeDao greeEmployeeDaoDbImpl;

	@Override
	public GreeEmployee getByUserIdOrTel(Long userId, String tel) {
		return greeEmployeeDaoDbImpl.getByUserIdOrTel(userId, tel);
	}

}
