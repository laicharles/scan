package com.lianyun.scan.frame.model;

import java.util.HashMap;
import java.util.Map;

public class PageCondition {

	/**
	 * 当前页数
	 */
	private int page = 1;

	/**
	 * 每页数量
	 */
	private int size = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public final Map<String, Object> toOut() {

		Map<String, Object> map = new HashMap<>();

		Long offset = 1L * (page - 1) * size;

		map.put("offset", offset);
		map.put("limit", size);

		fill(map);
		return map;
	}

	public void fill(Map<String, Object> map) {

	}

}
