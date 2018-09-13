package com.lianyun.scan.gree.ad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.gree.ad.model.GreeAdDemo;
import com.lianyun.scan.gree.model.condition.NamePageCondition;

/**
 * @author 560133
 *
 *         demo
 * 
 *         列表接口 /ad/demo get
 * 
 *         保存接口 /ad/demo post 无id为添加接口，带上id为修改接口
 * 
 *         获取对象接口 /ad/demo/{id} get
 * 
 *         删除对象接口 /ad/demo/delete/{id} post
 * 
 *         启用对象接口 /ad/demo/work post 
 */
@Controller
@RequestMapping(value = "/ad/demo")
public class DemoGreeAdController extends AbstractGreeAdController<Long, GreeAdDemo, NamePageCondition> {

}
