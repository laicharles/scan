package com.lianyun.scan.dao.web;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.AdminOperation;
import com.lianyun.scan.webservice.inner.model.WebLog;

@Repository
public class AdminOperationDaoWebImpl extends BaseDaoWebImpl<Long, AdminOperation, WebLog> {

	private final int platFormType = 1;

	@Override
	protected void fill(Map<String, Object> uriVariables) {
		uriVariables.put("platFormType", platFormType);
		super.fill(uriVariables);
	}
	
	
	@Override
	protected WebLog toOut0(AdminOperation in) {

		WebLog webLog = new WebLog();
		webLog.setIp(in.getIp());
		webLog.setMessage(in.getMessage());
		webLog.setPlatFormType(platFormType);

		return webLog;
	}

	@Override
	protected AdminOperation toIn0(WebLog out) {

		if (out.getPlatFormType() != platFormType) {
			return null;
		}

		AdminOperation adminOperation = new AdminOperation();
		adminOperation.setCreateTime(out.getCreateTime());
		adminOperation.setId(out.getId());
		adminOperation.setIp(out.getIp());
		adminOperation.setMessage(out.getMessage());
		adminOperation.setUpdateTime(out.getCreateTime());

		return adminOperation;
	}

}
