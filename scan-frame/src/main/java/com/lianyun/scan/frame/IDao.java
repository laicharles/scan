package com.lianyun.scan.frame;

import java.util.List;

import com.lianyun.scan.frame.model.PageCondition;

public interface IDao<K, V> {

	List<V> list(PageCondition pageCondition);

	long count(PageCondition pageCondition);

	V get(K k);

	boolean add(V v);

	boolean edit(K k, V v);

	boolean delete(K k);

}
