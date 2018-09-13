package com.lianyun.scan.util;

import com.lianyun.scan.frame.model.Context;

public class ContextUtil {

	private final static ThreadLocal<Context> t = new ThreadLocal<>();

	public static Context getContext() {
		return t.get();
	}

	public static void setContext(Context context) {
		t.set(context);
	}

}
