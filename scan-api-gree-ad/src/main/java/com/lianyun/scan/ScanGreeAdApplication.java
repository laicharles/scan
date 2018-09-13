package com.lianyun.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lianyun.scan.gree.GreeApplication;

@EnableJpaRepositories(basePackages = "com.lianyun.scan.gree.ad.dao.db")
public class ScanGreeAdApplication extends GreeApplication {

	public static void main(String[] args) {

		setLogDir("gree/ad");
		SpringApplication.run(ScanGreeAdApplication.class, args);

	}
}
