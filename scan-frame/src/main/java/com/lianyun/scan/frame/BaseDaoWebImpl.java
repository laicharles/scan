package com.lianyun.scan.frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lianyun.scan.frame.model.InOutAble;
import com.lianyun.scan.frame.model.PageCondition;

public abstract class BaseDaoWebImpl<K, IN, OUT> implements IDao<K, IN>, InOutAble<IN, OUT> {

	@Autowired
	private IWebService<K, OUT> iWebService;

	protected abstract OUT toOut0(IN in);

	protected abstract IN toIn0(OUT out);

	@Override
	public final OUT toOut(IN in) {
		if (in == null) {
			return null;
		}
		return toOut0(in);
	}

	@Override
	public final IN toIn(OUT out) {
		if (out == null) {
			return null;
		}
		return toIn0(out);
	}

	protected void fill(Map<String, Object> uriVariables) {

	}

	@Override
	public List<IN> list(PageCondition pageCondition) {
		Map<String, Object> uriVariables = new HashMap<>();
		if (pageCondition != null) {
			uriVariables = pageCondition.toOut();
		}

		fill(uriVariables);

		List<IN> ins = new ArrayList<>();
		List<OUT> outs = iWebService.list(uriVariables);
		if (outs != null) {
			for (OUT out : outs) {
				ins.add(toIn(out));
			}
		}

		return ins;
	}

	@Override
	public long count(PageCondition pageCondition) {
		Map<String, Object> uriVariables = new HashMap<>();
		if (pageCondition != null) {
			uriVariables = pageCondition.toOut();
		}
		fill(uriVariables);

		return iWebService.count(uriVariables);
	}

	@Override
	public IN get(K k) {
		OUT out = iWebService.get(k);
		return toIn(out);
	}

	@Override
	public boolean add(IN v) {
		OUT out = toOut(v);
		iWebService.add(out);
		return true;
	}

	@Override
	public boolean delete(K k) {
		iWebService.delete(k);
		return true;
	}

	@Override
	public boolean edit(K k, IN v) {
		OUT out = toOut(v);
		iWebService.edit(k, out);
		return true;
	}

}
