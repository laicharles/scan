package com.lianyun.scan.gree.webservice.greeimage;

import com.github.wxpay.sdk.WXPayUtil;

class GreeimageSignatureUtil {

	private static final String APIKEY = "662d9afde38e010fdb485d07414091d5";

	public static String getSign(String timestamp) throws Exception {
		// 计算sign
		String sign = WXPayUtil.MD5(APIKEY + "_" + timestamp).toLowerCase();
		return sign;
	}

}
