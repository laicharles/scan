package com.lianyun.scan.gree.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lianyun.scan.frame.BaseServiceImpl;
import com.lianyun.scan.frame.IDao;
import com.lianyun.scan.gree.model.GreeEmployee;
import com.lianyun.scan.model.EnterpriseRole;

@Service
public class GreeEmployeeServiceImpl extends BaseServiceImpl<Long, GreeEmployee> {

	@Autowired
	private IDao<Long, EnterpriseRole> enterpriseRoleDao;

	@Override
	public boolean add(GreeEmployee greeEmployee) {

		Set<Long> roleIds = new HashSet<>();
		greeEmployee.setRoleIds(roleIds);
		List<EnterpriseRole> roles = greeEmployee.getRoles();
		for (EnterpriseRole role : roles) {
			roleIds.add(role.getId());
		}
		greeEmployee.setRoleIds(roleIds);
		return super.add(greeEmployee);
	}

	@Override
	public GreeEmployee get(Long k) {
		GreeEmployee greeEmployee = super.get(k);
		if (greeEmployee == null) {
			return null;
		}

		Set<Long> roleIds = greeEmployee.getRoleIds();
		List<EnterpriseRole> roles = new ArrayList<>();
		for (Long roleId : roleIds) {
			EnterpriseRole role = enterpriseRoleDao.get(roleId);
			roles.add(role);
		}
		greeEmployee.setRoles(roles);

		return greeEmployee;
	}

}
