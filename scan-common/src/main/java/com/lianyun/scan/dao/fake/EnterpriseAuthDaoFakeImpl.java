package com.lianyun.scan.dao.fake;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoFakeImpl;
import com.lianyun.scan.model.EnterpriseAuth;

@Repository
public class EnterpriseAuthDaoFakeImpl extends BaseDaoFakeImpl<Long, EnterpriseAuth> {

	@Override
	protected Map<Long, EnterpriseAuth> map() {

		Map<Long, EnterpriseAuth> map = new HashMap<>();
		{
			EnterpriseAuth enterpriseAuth = new EnterpriseAuth();
			enterpriseAuth.setId(1L);
			enterpriseAuth.setName("全部");
			enterpriseAuth.setRefer("?*");
			map.put(enterpriseAuth.getId(), enterpriseAuth);
		}
		return map;
	}

}
