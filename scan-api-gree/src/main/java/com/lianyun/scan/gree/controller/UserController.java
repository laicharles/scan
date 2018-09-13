package com.lianyun.scan.gree.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.gree.util.SessionUtil;
import com.lianyun.scan.gree.webservice.greemember.component.GreememberComponent;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfo;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private GreememberComponent greememberComponent;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object info(HttpSession session) throws Exception {

		UserLogin userLogin = SessionUtil.getUserLogin(session);
		UserInfo info = greememberComponent.getUserInfo(userLogin);
		if (userLogin.isChange()) {
			userLogin.setChange(false);
			SessionUtil.setUserLogin(session, userLogin);
		}
		return info;

	}

}
