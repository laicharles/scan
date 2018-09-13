package com.lianyun.scan;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class ScanConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new ScanGsonHttpMessageConverter());
	}

//	 @Override  
//	    public void addCorsMappings(CorsRegistry registry) {  
//	        registry.addMapping("/**")  
//	                .allowedOrigins("*")  
//	                .allowCredentials(true)  
//	                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "OPTIONS", "PATCH")  
//	                .maxAge(3600);  
//	    } 
	
}
