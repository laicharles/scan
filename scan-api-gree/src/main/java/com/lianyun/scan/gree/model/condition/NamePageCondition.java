package com.lianyun.scan.gree.model.condition;

import java.util.Map;

import com.lianyun.scan.frame.model.Condition;
import com.lianyun.scan.frame.model.ConditionType;
import com.lianyun.scan.frame.model.PageCondition;

public class NamePageCondition extends PageCondition {

	@Condition(value = "name", type = ConditionType.LIKE)
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public void fill(Map<String, Object> map) {
		
		map.put("keyword", keyword);
		super.fill(map);
	}

}
