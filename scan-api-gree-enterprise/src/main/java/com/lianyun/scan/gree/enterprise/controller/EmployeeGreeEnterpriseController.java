package com.lianyun.scan.gree.enterprise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.frame.IService;
import com.lianyun.scan.gree.model.GreeEmployee;
import com.lianyun.scan.gree.model.condition.NamePageCondition;
import com.lianyun.scan.model.Employee;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.model.EnterpriseOperation;

/**
 * @author 560133
 *
 *         账号
 *
 */
@Controller
@RequestMapping(value = "/enterprise/employee")
public class EmployeeGreeEnterpriseController
		extends AbstractGreeEnterpriseController<Long, GreeEmployee, NamePageCondition> {

	@Autowired
	private IService<Long, EnterpriseOperation> enterpriseOperationService;

	@Override
	protected void add0(GreeEmployee v) {
		// TODO 后续改成切面编程
		EnterpriseOperation operation = new EnterpriseOperation();
		
		Enterprise enterprise = new Enterprise();	
		enterprise.setId(1L);
		operation.setEnterprise(enterprise);
		
		Employee employee = new Employee();
		employee.setId(1L);
		operation.setEmployee(employee);
		
		operation.setIp("127.0.0.1");
		operation.setMessage("添加账号");
		
		enterpriseOperationService.add(operation);

		super.add0(v);
	}

}
