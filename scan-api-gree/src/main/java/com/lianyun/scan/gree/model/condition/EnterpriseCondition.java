package com.lianyun.scan.gree.model.condition;

import java.util.Map;

public class EnterpriseCondition extends NamePageCondition {

	private long enterpriseId;

	public long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Override
	public void fill(Map<String, Object> map) {
		map.put("enterpriseId", enterpriseId);
		super.fill(map);
	}

}
