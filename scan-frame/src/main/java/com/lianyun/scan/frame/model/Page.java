package com.lianyun.scan.frame.model;

import java.util.List;

public class Page<T> {

	public Page(PageCondition pageCondition, List<T> records, long count) {
		this.page = pageCondition.getPage();
		this.size = pageCondition.getSize();
		this.records = records;
		this.count = count;
		this.totalPage = (long) Math.ceil(1.0 * count / size);
	}

	/**
	 * 当前页数
	 */
	private long page;

	/**
	 * 每页数量
	 */
	private long size;

	private List<T> records;

	/**
	 * 分页总数
	 */
	private long totalPage;

	/**
	 * 记录总数
	 */
	private long count;

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
