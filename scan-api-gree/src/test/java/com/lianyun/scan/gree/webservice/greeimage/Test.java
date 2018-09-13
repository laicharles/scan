package com.lianyun.scan.gree.webservice.greeimage;

import java.util.HashMap;
import java.util.Map;

import com.lianyun.scan.gree.webservice.greeimage.GreeimageWebUtil.RequestResult;
import com.lianyun.scan.webservice.inner.model.WebCaptcha;

public class Test {

	public static void main(String[] args) {
		String urlString = "http://10.2.46.209:8080/create?length=4&height=50";

		Map<String, String> headers = new HashMap<>();
		headers.put("Accept", "application/json;charset=UTF-8");
		headers.put("Cookie", "JSESSIONID=B41DF4A62110F4FA4E3CDC2002B71DE1");

		RequestResult<WebCaptcha> r = GreeimageWebUtil.get(urlString, 1000, headers, WebCaptcha.class);
		System.out.println(r.getBody().getCode());
	}

}
