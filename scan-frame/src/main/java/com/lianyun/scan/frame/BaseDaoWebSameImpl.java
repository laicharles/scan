package com.lianyun.scan.frame;

public abstract class BaseDaoWebSameImpl<K, V> extends BaseDaoWebImpl<K, V, V> {

	@Override
	public V toOut0(V in) {
		return in;
	}

	@Override
	public V toIn0(V out) {
		return out;
	}

}
