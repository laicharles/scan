package com.lianyun.scan.frame;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lianyun.scan.frame.model.Context;
import com.lianyun.scan.frame.model.WebModel;
import com.lianyun.scan.util.ContextUtil;
import com.lianyun.scan.util.HttpUtil;
import com.lianyun.scan.util.JsonUtil;

public abstract class BaseWebServiceImpl<K, V extends WebModel> implements IWebService<K, V> {

	protected static Logger logger = LoggerFactory.getLogger(BaseWebServiceImpl.class);

	private Class<V> clazz;

	public BaseWebServiceImpl() {

		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<V>) pt.getActualTypeArguments()[1];
		listType = new ParameterizedTypeImpl(clazz);
	}

	@Autowired
	private RestTemplate restTemplate;

	protected abstract String host();

	protected abstract String path();

	private HttpHeaders requestHeaders;

	@Value("${auth.name}")
	private String name;

	@Value("${auth.password}")
	private String password;

	private HttpEntity<String> requestEntity;
	{
		requestHeaders = new HttpHeaders();

		requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

		requestHeaders.add(HttpHeaders.AUTHORIZATION, "Basic "
				+ Base64.getEncoder().encodeToString((name + ":" + password).getBytes(Charset.forName("UTF-8"))));
		requestHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
		requestEntity = new HttpEntity<String>(null, requestHeaders);
	}

	private class ParameterizedTypeImpl implements ParameterizedType {
		Class<V> clazz;

		public ParameterizedTypeImpl(Class<V> clz) {
			clazz = clz;
		}

		@Override
		public Type[] getActualTypeArguments() {
			return new Type[] { clazz };
		}

		@Override
		public Type getRawType() {
			return List.class;
		}

		@Override
		public Type getOwnerType() {
			return null;
		}
	}

	private Type listType;

	private String getUrl() {
		return getUrl(null);
	}

	private String getUrl(Map<String, ?> uriVariables) {

		// 使用threadlocal 替换url的占位符

		String url = "http://" + host() + "/" + path();

		Context context = ContextUtil.getContext();
		if (context != null) {
			Map<String, Object> params = context.getParams();

			for (String key : params.keySet()) {

				String z = "{" + key + "}";

				if (url.contains(z)) {
					Object value = params.get(key);
					url = url.replace(z, value + "");
				}

			}
		}

		if (uriVariables == null || uriVariables.isEmpty()) {
			return url;
		}

		return url + "?" + HttpUtil.toQuery(uriVariables);

	}

	@Override
	public long count(Map<String, ?> uriVariables) {

		ResponseEntity<String> response = restTemplate.exchange(getUrl(uriVariables), HttpMethod.HEAD, requestEntity,
				String.class);

		HttpHeaders headers = response.getHeaders();

		List<String> values = headers.get("Count");
		if (values == null || values.isEmpty()) {
			return 0;
		}
		return Long.parseLong(values.get(0));
	}

	@Override
	public V add(V v) {

		HttpEntity<String> requestEntity = new HttpEntity<String>(JsonUtil.toJson(v), requestHeaders);
		ResponseEntity<String> response = restTemplate.exchange(getUrl(), HttpMethod.POST, requestEntity, String.class);

		return JsonUtil.fromJson(response.getBody(), clazz);

	}

	@Override
	public V edit(K id, V v) {

		HttpEntity<String> requestEntity = new HttpEntity<String>(JsonUtil.toJson(v), requestHeaders);
		ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/" + id, HttpMethod.PUT, requestEntity,
				String.class);

		return JsonUtil.fromJson(response.getBody(), clazz);

	}

	@Override
	public List<V> list(Map<String, ?> uriVariables) {

		ResponseEntity<String> response = restTemplate.exchange(getUrl(uriVariables), HttpMethod.GET, requestEntity,
				String.class, uriVariables);

		String body = response.getBody();
		List<V> list = JsonUtil.fromJson(body, listType);
		return list;

	}

	@Override
	public V get(K id) {

		ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/" + id, HttpMethod.GET, requestEntity,
				String.class);

		String body = response.getBody();

		logger.info("body:" + body);

		return JsonUtil.fromJson(body, clazz);

	}

	@Override
	public V delete(K id) {

		ResponseEntity<String> response = restTemplate.exchange(getUrl() + "/" + id, HttpMethod.DELETE, requestEntity,
				String.class);

		return JsonUtil.fromJson(response.getBody(), clazz);
	}

}
