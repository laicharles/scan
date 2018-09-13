package com.lianyun.scan;

import org.springframework.boot.SpringApplication;

import com.lianyun.scan.gree.GreeApplication;

public class ScanGreeUserApplication extends GreeApplication {

	public static void main(String[] args) {

		setLogDir("gree/user");

		SpringApplication.run(ScanGreeUserApplication.class, args);

	}
}
