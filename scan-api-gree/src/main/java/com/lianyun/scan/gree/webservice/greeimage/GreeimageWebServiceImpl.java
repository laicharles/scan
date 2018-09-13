package com.lianyun.scan.gree.webservice.greeimage;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lianyun.scan.gree.webservice.greeimage.GreeimageWebUtil.RequestResult;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.CategoryGreeimageRespond;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.GreeimageCategory;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.GreeimageLog;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.LogGreeimageRespond;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.ProductGreeimageRespond;
import com.lianyun.scan.util.JsonUtil;

@Component
public class GreeimageWebServiceImpl implements GreeimageWebService {

	@Override
	public List<GreeimageCategory> listCategorys() {
		String url = "https://q.gree.com/qr/getProdCat";

		RequestResult<CategoryGreeimageRespond> requestResult = GreeimageWebUtil.get(url, 1000,
				CategoryGreeimageRespond.class);
		return requestResult.getBody().getRealData();
	}

	@Override
	public List<GreeimageLog> listLogs(long startSecond, long endSecond) {
		String url = "https://q.gree.com/qr/logByTime?start=" + startSecond + "&end=" + endSecond;

		RequestResult<LogGreeimageRespond> requestResult = GreeimageWebUtil.get(url, 1000, LogGreeimageRespond.class);
		return requestResult.getBody().getRealData();
	}

	@Override
	public Map<String, Object> getProduct(String pp, String xh) {
		String url = "https://q.gree.com/qr/prod/get?pp=" + pp + "&xh=" + xh;

		RequestResult<ProductGreeimageRespond> requestResult = GreeimageWebUtil.get(url, 1000, ProductGreeimageRespond.class);
		return requestResult.getBody().getRealData();
	}

	public static void main(String[] args) {
		// System.out.println(JsonUtil.toJson(new
		// GreeimageWebServiceImpl().listCategorys()));

		long endSecond = System.currentTimeMillis() / 1000;

		long startSecond = endSecond - 3600 * 24 * 30;

		System.out.println(JsonUtil.toJson(new GreeimageWebServiceImpl().listLogs(startSecond, endSecond)));

		System.out.println(JsonUtil.toJson(new GreeimageWebServiceImpl().getProduct("GREE", "KFR-50L(50577)FNhAa-A1")));

	}

}
