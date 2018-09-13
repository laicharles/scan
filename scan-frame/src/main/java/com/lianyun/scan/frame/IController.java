package com.lianyun.scan.frame;

import java.util.List;

import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.Page;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.frame.model.Work;

public interface IController<K, V, P extends PageCondition> {

	Page<V> page(P p);

	V get(K k);

	void add(V v);

	void edit(K k, V v);

	void delete(K k);

	void multiDelete(List<IdAble<K>> ids);

	void work(Work<K> work);

}
