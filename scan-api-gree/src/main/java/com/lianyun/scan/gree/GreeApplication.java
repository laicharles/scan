package com.lianyun.scan.gree;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lianyun.scan.Application;


@EnableJpaRepositories(basePackages = "com.lianyun.scan.gree.dao.db")
public class GreeApplication extends Application{

}
