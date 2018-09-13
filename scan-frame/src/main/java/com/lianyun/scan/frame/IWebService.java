package com.lianyun.scan.frame;

import java.util.List;
import java.util.Map;

public interface IWebService<K, V> {

	long count(Map<String, ?> uriVariables);

	V add(V v);

	V edit(K k, V v);

	List<V> list(Map<String, ?> uriVariables);

	V get(K k);

	V delete(K k);

}
