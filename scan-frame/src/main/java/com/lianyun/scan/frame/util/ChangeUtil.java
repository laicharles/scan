package com.lianyun.scan.frame.util;

import java.util.Map;

public class ChangeUtil {

	public static void renameKey(Map<String, Object> uriVariables, String oldKey, String newKey) {

		if (uriVariables == null || oldKey == null) {
			return;
		}
		if (!uriVariables.containsKey(oldKey)) {
			return;
		}

		Object v = uriVariables.get(oldKey);
		uriVariables.remove(oldKey);

		uriVariables.put(newKey, v);
	}

}
