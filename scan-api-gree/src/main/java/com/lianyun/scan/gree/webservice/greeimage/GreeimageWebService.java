package com.lianyun.scan.gree.webservice.greeimage;

import java.util.List;
import java.util.Map;

import com.lianyun.scan.gree.webservice.greeimage.model.respond.GreeimageCategory;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.GreeimageLog;

public interface GreeimageWebService {

	List<GreeimageCategory> listCategorys();

	List<GreeimageLog> listLogs(long startSecond, long endSecond);

	Map<String, Object> getProduct(String pp, String xh);

}
