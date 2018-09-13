package com.lianyun.scan.dao.fake;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoFakeImpl;
import com.lianyun.scan.model.AdminAuth;

@Repository
public class AdminAuthDaoFakeImpl extends BaseDaoFakeImpl<Long, AdminAuth> {

	@Override
	protected Map<Long, AdminAuth> map() {

		Map<Long, AdminAuth> map = new HashMap<>();
		{
			AdminAuth adminAuth = new AdminAuth();
			
			map.put(adminAuth.getId(), adminAuth);
		}
		return map;
	}

}
