package com.lianyun.scan.dao.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.model.EnterpriseAuth;
import com.lianyun.scan.model.EnterpriseRole;
import com.lianyun.scan.webservice.inner.model.WebEnterpriseRole;

@Repository
public class EnterpriseRoleDaoWebImpl extends BaseDaoWebImpl<Long, EnterpriseRole, WebEnterpriseRole> {

	@Override
	protected WebEnterpriseRole toOut0(EnterpriseRole in) {

		WebEnterpriseRole webEnterpriseRole = new WebEnterpriseRole();

		List<Long> authIds = new ArrayList<>();
		for (EnterpriseAuth auth : in.getAuths()) {
			authIds.add(auth.getId());
		}

		webEnterpriseRole.setAuthIds(authIds);
		webEnterpriseRole.setCreateTime(in.getCreateTime());
		webEnterpriseRole.setDesc(in.getDesc());
		webEnterpriseRole.setId(in.getId());
		webEnterpriseRole.setName(in.getName());
		webEnterpriseRole.setWork(in.isWork());
		return webEnterpriseRole;
	}

	@Override
	protected EnterpriseRole toIn0(WebEnterpriseRole out) {

		EnterpriseRole enterpriseRole = new EnterpriseRole();

		List<EnterpriseAuth> auths = new ArrayList<>();

		List<Long> authIds = out.getAuthIds();
		for (Long authId : authIds) {
			EnterpriseAuth auth = new EnterpriseAuth();
			auth.setId(authId);
			auths.add(auth);
		}

		enterpriseRole.setAuths(auths);
		enterpriseRole.setCreateTime(out.getCreateTime());
		enterpriseRole.setDesc(out.getDesc());
		Enterprise enterprise = new Enterprise();
		enterprise.setId(out.getEid());
		enterpriseRole.setEnterprise(enterprise);
		enterpriseRole.setId(out.getId());
		enterpriseRole.setName(out.getName());
		enterpriseRole.setUpdateTime(out.getUpdateTime());
		enterpriseRole.setWork(out.isWork());
		return enterpriseRole;
	}

}
