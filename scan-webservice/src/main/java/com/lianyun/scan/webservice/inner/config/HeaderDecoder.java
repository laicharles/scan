package com.lianyun.scan.webservice.inner.config;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import com.lianyun.scan.frame.model.Header;
import com.lianyun.scan.util.JsonUtil;

import feign.Response;

public class HeaderDecoder extends SpringDecoder {

	public HeaderDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		super(messageConverters);
	}

	@Override
	public Object decode(Response response, Type type) throws IOException {

		Object object = super.decode(response, type);

		try {

			if (type instanceof Class) {
				Class<?> c = (Class<?>) type;
				Field[] fields = c.getDeclaredFields();

				Map<String, Object> temp = new HashMap<>();

				for (Field field : fields) {
					Header header = field.getAnnotation(Header.class);

					if (header != null) {
						if(object==null) {
							object = c.newInstance();
						}
						String k = header.value();
						Collection<String> values = response.headers().get(k);
						if (values == null) {
							continue;
						}
						String v = "";
						for (String value : values) {
							v = value;
						}

						temp.put(field.getName(), v);
					}
				}

				if (temp.isEmpty()) {
					return object;
				}
				Object object2 = JsonUtil.fromJson(JsonUtil.toJson(temp), c);

				if (object == null) {
					return object2;
				}

				for (Field field : fields) {

					Header header = field.getAnnotation(Header.class);

					if (header != null) {
						field.setAccessible(true);
						field.set(object, field.get(object2));

					}

				}

			}
		} catch (Exception e) {
			throw new IOException(e);
		}
		return object;
	}

}
