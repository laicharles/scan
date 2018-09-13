package com.lianyun.scan.frame;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.frame.model.ControllerMethod;
import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.Page;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.frame.model.Switch;
import com.lianyun.scan.frame.model.Work;

public abstract class BaseController<K, V extends IdAble<K>, P extends PageCondition> implements IController<K, V, P> {

	protected final RuntimeException exception = new UnsupportedOperationException("不支持该接口");

	@Autowired
	private IService<K, V> service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@Override
	public final Page<V> page(P p) {
		check(ControllerMethod.PAGE);
		return page0(p);
	}

	@RequestMapping(value = "/{k}", method = RequestMethod.GET)
	@ResponseBody
	@Override
	public final V get(@PathVariable K k) {
		check(ControllerMethod.GET);
		return get0(k);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public final void save(@RequestBody V v) {
		K id = v.getId();
		if (id == null) {
			add(v);
		} else {
			edit(id, v);
		}

	}

	@Override
	public final void add(@RequestBody V v) {
		check(ControllerMethod.ADD);
		add0(v);
	}

	@RequestMapping(method = RequestMethod.POST, params = "id")
	@ResponseBody
	@Override
	public final void edit(K k, @RequestBody V v) {
		check(ControllerMethod.EDIT);
		edit0(k, v);
	}

	@RequestMapping(value = "/delete/{k}", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public final void delete(@PathVariable K k) {
		check(ControllerMethod.DELETE);
		delete0(k);
	}

	@RequestMapping(value = "/multiDelete", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public final void multiDelete(List<IdAble<K>> ids) {
		check(ControllerMethod.DELETE);

		for (IdAble<K> id : ids) {
			delete0(id.getId());
		}

	}

	@RequestMapping(value = "/work", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public final void work(@RequestBody Work<K> work) {
		check(ControllerMethod.WORK);
		work0(work);
	}

	protected Page<V> page0(P p) {
		long count = service.count(p);
		List<V> records = service.list(p);
		return new Page<V>(p, records, count);
	}

	protected V get0(K id) {
		return service.get(id);
	}

	protected void add0(V v) {
		service.add(v);
	}

	protected void edit0(K k, V v) {
		service.edit(k, v);
	}

	protected void delete0(K id) {
		service.delete(id);
	}

	protected void work0(Work<K> work) {
		K id = work.getId();
		V v = service.get(id);

		if (v == null) {
			return;
		}

		if (v instanceof Switch) {
			Switch s = (Switch) v;
			s.setWork(work.isWork());
			service.edit(id, v);
		} else {
			throw exception;
		}
	}

	private void check(ControllerMethod controllerMethod) {
		if (noSupportMethodNames.contains(controllerMethod)) {
			throw exception;
		}
	}

	private Collection<ControllerMethod> noSupportMethodNames = noSupportMethodNames();

	protected Collection<ControllerMethod> noSupportMethodNames() {
		return Collections.emptyList();
	}

}
