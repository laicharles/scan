package com.lianyun.scan.gree.webservice.greeimage;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lianyun.scan.exception.BusinessProjectException;
import com.lianyun.scan.util.JsonUtil;

class GreeimageWebUtil {

	protected static Logger logger = LoggerFactory.getLogger(GreeimageWebUtil.class);

	public static class RequestResult<T> {

		private int cost;
		private int code;
		private boolean ok;
		private T body;
		private String error;

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public boolean isOk() {
			return ok;
		}

		public void setOk(boolean ok) {
			this.ok = ok;
		}

		public T getBody() {
			if (!ok) {
				throw new BusinessProjectException(error);
			}
			return body;
		}

		public void setBody(T body) {
			this.body = body;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		@Override
		public String toString() {
			return "RequestResult [cost=" + cost + ", code=" + code + ", ok=" + ok + ", body=" + body + ", error="
					+ error + "]";
		}

	}

	public static <T> RequestResult<T> get(String urlString, int timeout, Class<T> cls) {
		return get(urlString, timeout, Collections.emptyMap(), cls);
	}

	public static <T> RequestResult<T> get(String urlString, int timeout, Map<String, String> headers, Class<T> cls) {

		RequestResult<T> requestResult = new RequestResult<T>();

		URL url = null;
		HttpURLConnection httpConn = null;
		String result = "";
		try {
			url = new URL(urlString);
			httpConn = (HttpURLConnection) url.openConnection();

			// A URL connection can be used for input and/or output. Set the
			// DoInput flag to true if you intend to use the URL connection for input,
			// false if not. The default is true.

			// URL连接可用于input或output。如果想用URL连接输入，设置DoInput标签为true。
			// 输入和输出是针对计算机的，如果以程序员的角度考虑，经常弄混。
			// input输入，output输出，那么不是从output里read，input中write吗，其实相反
			// input输入进计算机，计算机才能读，所以是从input read，而output是计算机输出，通过output write。
			httpConn.setDoOutput(false);
			// 所以如果setDoInput(false)，想从URLConnection读取时不能读取
			// Cannot read from URLConnection if doInput=false (call setDoInput(true))
			httpConn.setDoInput(true);

			// 连接建立超时时间还有读取数据超时时间，
			httpConn.setConnectTimeout(timeout);
			httpConn.setReadTimeout(timeout);
			httpConn.setRequestMethod("GET");

			for (Entry<String, String> entry : headers.entrySet()) {
				httpConn.setRequestProperty(entry.getKey(), entry.getValue());
			}

			{
				// 计算sign

				String timestamp = System.currentTimeMillis() / 1000 + "";
				String sign = GreeimageSignatureUtil.getSign(timestamp);

				httpConn.setRequestProperty("t", timestamp);
				httpConn.setRequestProperty("vc", sign);

			}

			long now = System.currentTimeMillis();

			httpConn.connect();

			// 获取状态码
			int code = httpConn.getResponseCode();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(httpConn.getInputStream(), baos);
			result = baos.toString();

			requestResult.setBody(JsonUtil.fromJson(result, cls));

			requestResult.setCode(code);

			int cost = (int) (System.currentTimeMillis() - now);
			requestResult.setCost(cost);

			httpConn.disconnect();
			requestResult.setOk(true);
		} catch (Exception e) {
			requestResult.setOk(false);
			requestResult.setError(e.toString());
		} finally {
			if (httpConn != null)
				httpConn.disconnect();
			
			System.out.println(result);
			
			logger.info("GET url[{}], result[{}], requestResult[{}]", url, result, requestResult);
		}

		return requestResult;

	}

}
