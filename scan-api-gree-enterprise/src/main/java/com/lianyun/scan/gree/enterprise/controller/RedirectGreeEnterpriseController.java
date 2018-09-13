package com.lianyun.scan.gree.enterprise.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.gree.util.SessionUtil;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;

@Controller
@RequestMapping(value = "/enterprise/redirect")
public class RedirectGreeEnterpriseController {

	@Value("${greeimage.loginUrl}")
	private String greeimageLoginUrl;

	@RequestMapping("/greeimage")
	public String greeimage(HttpSession session) throws Exception {

		UserLogin userLogin = SessionUtil.getUserLogin(session);

		LoginRespond loginRespond = userLogin.getLoginRespond();
		String token = loginRespond.getToken();
		int platformType = 0;
		long exp = loginRespond.getRefreshExp();

		return "redirect:" + greeimageLoginUrl + "?token=" + token + "&platformType=" + platformType + "&exp=" + exp;
	}

}
