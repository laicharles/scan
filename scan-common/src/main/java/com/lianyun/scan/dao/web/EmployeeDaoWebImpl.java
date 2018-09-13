package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Employee;
import com.lianyun.scan.webservice.inner.model.WebEmployee;

@Repository
public class EmployeeDaoWebImpl extends BaseDaoWebImpl<Long, Employee,WebEmployee> {

	@Override
	protected WebEmployee toOut0(Employee in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Employee toIn0(WebEmployee out) {
		// TODO Auto-generated method stub
		return null;
	}

}
