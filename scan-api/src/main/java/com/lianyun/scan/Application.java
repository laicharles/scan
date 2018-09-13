package com.lianyun.scan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lianyun.scan.dao")
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients
@EnableRedisHttpSession
@ServletComponentScan
public abstract class Application {

	static {
		String active = System.getProperty("spring.profiles.active");
		active = "dev";
		System.setProperty("spring.profiles.active", active + "," + active + "-self");

	}

	protected static void setLogDir(String name) {
		System.setProperty("logDir", "/data2/log/scan/" + name);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
