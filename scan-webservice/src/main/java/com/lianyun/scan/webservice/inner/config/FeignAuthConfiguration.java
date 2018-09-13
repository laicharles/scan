package com.lianyun.scan.webservice.inner.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;

@Configuration
public class FeignAuthConfiguration {

	@Value("${auth.name}")
	private String name;

	@Value("${auth.password}")
	private String password;

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(name, password);
	}

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;
	
	@Bean
	public Decoder decoder() {
		return new HeaderDecoder(messageConverters);
	}

}
