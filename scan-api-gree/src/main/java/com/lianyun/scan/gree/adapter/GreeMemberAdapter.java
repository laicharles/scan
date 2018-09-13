package com.lianyun.scan.gree.adapter;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.lianyun.scan.ScanConfiguration;

@SpringBootConfiguration
public class GreeMemberAdapter extends ScanConfiguration {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(new GreeMemberConfig()).addPathPatterns("/user/**");
	}

}
