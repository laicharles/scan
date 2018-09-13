package com.lianyun.scan.frame;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lianyun.scan.exception.IdNoFoundProjectException;
import com.lianyun.scan.frame.model.PageCondition;

public abstract class BaseServiceImpl<K, V> implements IService<K, V> {

	@Autowired
	private IDao<K, V> dao;

	@Override
	public List<V> list(PageCondition pageCondition) {
		return dao.list(pageCondition);
	}

	@Override
	public long count(PageCondition pageCondition) {
		return dao.count(pageCondition);
	}

	@Override
	public V get(K k) {
		return dao.get(k);
	}

	@Override
	public boolean add(V v) {
		return dao.add(v);
	}

	@Override
	public boolean delete(K k) {
		return dao.delete(k);
	}

	@Override
	public boolean edit(K k, V v) {
		V v0 = this.get(k);
		if (v0 == null) {
			throw new IdNoFoundProjectException(k);
		}
		return dao.edit(k, v);
	}

}
