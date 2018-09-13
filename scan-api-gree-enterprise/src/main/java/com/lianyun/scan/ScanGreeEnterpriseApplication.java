package com.lianyun.scan;

import org.springframework.boot.SpringApplication;

import com.lianyun.scan.gree.GreeApplication;


public class ScanGreeEnterpriseApplication extends GreeApplication{

	public static void main(String[] args) {
		
		setLogDir("gree/enterprise");
		
		SpringApplication.run(ScanGreeEnterpriseApplication.class, args);
	}
}
