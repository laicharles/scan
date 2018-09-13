package com.lianyun.scan.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lianyun.scan.frame.model.PageCondition;

public abstract class BaseDaoFakeImpl<K, V> implements IDao<K, V> {

	private Map<K, V> map = map();

	protected abstract Map<K, V> map();

	@Override
	public List<V> list(PageCondition pageCondition) {
		return new ArrayList<>(map.values());
	}

	@Override
	public long count(PageCondition pageCondition) {
		return map.values().size();
	}

	@Override
	public V get(K k) {
		return map.get(k);
	}

	@Override
	public boolean add(V v) {
		throw new UnsupportedOperationException("不支持该接口");
	}

	@Override
	public boolean delete(K k) {
		throw new UnsupportedOperationException("不支持该接口");
	}

	@Override
	public boolean edit(K k, V v) {
		throw new UnsupportedOperationException("不支持该接口");
	}

	
	
}
