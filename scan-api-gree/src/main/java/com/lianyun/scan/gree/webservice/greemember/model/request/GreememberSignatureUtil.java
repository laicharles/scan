package com.lianyun.scan.gree.webservice.greemember.model.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.wxpay.sdk.WXPayUtil;

 class GreememberSignatureUtil {

	public static String getSign(String tel, String timestamp, String nonce) throws Exception {
		String sign = "";
		sign = WXPayUtil.MD5(tel).toLowerCase();
		sign = WXPayUtil.MD5(sign + timestamp).toLowerCase();
		sign = WXPayUtil.MD5(sign + nonce).toLowerCase();

		char[] cs = sign.toCharArray();

		List<Character> list = new ArrayList<>();

		for (char c : cs) {
			list.add(c);
		}

		Collections.sort(list);

		sign = StringUtils.join(list, "");

		sign = WXPayUtil.MD5(sign);

		sign = sign.toUpperCase();

		return sign;
	}

	public static void main(String[] args) throws Exception {

		String tel = "15916321224";
		long t = System.currentTimeMillis();
		String nonce = "123456";

		System.out.println("tel[" + tel + "], t[" + t + "], nonce[" + nonce + "], sign[" + getSign(tel, t+"", nonce) + "]");
	}

}
