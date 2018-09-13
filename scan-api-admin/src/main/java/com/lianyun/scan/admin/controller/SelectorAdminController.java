package com.lianyun.scan.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.frame.model.Selector;

@Controller
@RequestMapping(value = "/admin/selector")
public class SelectorAdminController {

	@RequestMapping(value = "/auths", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> auths() throws Exception {

		List<Selector> selectors = new ArrayList<>();
		// TODO 读数据库
		return selectors;
	}

	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> admins() throws Exception {
		List<Selector> selectors = new ArrayList<>();

		// TODO 读数据库

		return selectors;
	}

}
