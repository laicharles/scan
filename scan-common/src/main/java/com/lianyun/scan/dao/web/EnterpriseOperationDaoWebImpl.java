package com.lianyun.scan.dao.web;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.frame.util.ChangeUtil;
import com.lianyun.scan.model.Employee;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.model.EnterpriseOperation;
import com.lianyun.scan.webservice.inner.model.WebLog;

@Repository
public class EnterpriseOperationDaoWebImpl extends BaseDaoWebImpl<Long, EnterpriseOperation, WebLog> {

	private final int platFormType = 2;

	@Override
	protected void fill(Map<String, Object> uriVariables) {

		ChangeUtil.renameKey(uriVariables, "enterpriseId", "eid");
		uriVariables.put("platFormType", platFormType);
		super.fill(uriVariables);
	}

	@Override
	protected WebLog toOut0(EnterpriseOperation in) {
		WebLog webLog = new WebLog();
		webLog.setIp(in.getIp());
		webLog.setMessage(in.getMessage());
		webLog.setPlatFormType(platFormType);
		webLog.setEid(in.getEnterprise().getId());
		webLog.setOperatorId(in.getEmployee().getId());
		return webLog;
	}

	@Override
	protected EnterpriseOperation toIn0(WebLog out) {
		if (out.getPlatFormType() != platFormType) {
			return null;
		}

		EnterpriseOperation enterpriseOperation = new EnterpriseOperation();
		enterpriseOperation.setCreateTime(out.getCreateTime());
		enterpriseOperation.setId(out.getId());
		enterpriseOperation.setIp(out.getIp());
		enterpriseOperation.setMessage(out.getMessage());
		enterpriseOperation.setUpdateTime(out.getCreateTime());
		Enterprise enterprise = new Enterprise();
		enterprise.setId(out.getEid());
		enterpriseOperation.setEnterprise(enterprise);

		Employee employee = new Employee();
		employee.setId(out.getOperatorId());
		enterpriseOperation.setEmployee(employee);

		return enterpriseOperation;
	}

}
