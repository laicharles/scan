package com.lianyun.scan.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class HttpUtil {

	public static String toQuery(Map<String, ?> data) {

		List<String> items = new ArrayList<>();

		Set<String> keySet = data.keySet();

		for (String k : keySet) {

			String key = urlEncode(k);

			String value = urlEncode(data.get(k)+"");
					
			items.add(key+"="+value);

		}

		return StringUtils.join(items, "&");
	}

	private static String urlEncode(String s) {

		s = s.trim();
		try {
			return URLEncoder.encode(s, "utf8");
		} catch (Exception e) {
			return URLEncoder.encode(s);
		}

	}

}
