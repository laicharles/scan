package com.lianyun.scan.gree.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.frame.model.Selector;
import com.lianyun.scan.gree.webservice.greemember.component.GreememberComponent;
import com.lianyun.scan.gree.webservice.greemember.model.respond.PlatformRespond;

@Controller
@RequestMapping(value = "/selector")
public class SelectorController {

	@Autowired
	private GreememberComponent greememberComponent;

	@RequestMapping(value = "/platforms", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> platforms(HttpSession session) throws Exception {

		List<Selector> selectors = new ArrayList<>();

		List<PlatformRespond> platforms = greememberComponent.listPlatforms();
		for (PlatformRespond platformRespond : platforms) {
			Selector selector = new Selector();
			selector.setId(platformRespond.getIndex());
			selector.setName(platformRespond.getName());
			selectors.add(selector);
		}

		return selectors;
	}

}
