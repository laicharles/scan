package com.lianyun.scan.gree.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.exception.BusinessProjectException;
import com.lianyun.scan.gree.util.SessionUtil;
import com.lianyun.scan.gree.vo.RegisterUserVo;
import com.lianyun.scan.gree.vo.SendCodeVo;
import com.lianyun.scan.gree.vo.UserVo;
import com.lianyun.scan.gree.webservice.greemember.component.GreememberComponent;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;
import com.lianyun.scan.webservice.inner.CaptchaWebService;
import com.lianyun.scan.webservice.inner.model.WebCaptcha;

@Controller
public class IndexController {

	@Autowired
	private CaptchaWebService captchaWebService;

	@Autowired
	private GreememberComponent greememberComponent;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void login(HttpSession session, @RequestBody UserVo vo) throws Exception {

		LoginRespond loginRespond = greememberComponent.login(vo.getAccount(), vo.getPassword(), vo.getPlatformId());
		UserLogin userLogin = new UserLogin();
		userLogin.setLoginRespond(loginRespond);
		SessionUtil.setUserLogin(session, userLogin);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(@RequestBody RegisterUserVo vo) throws Exception {

		if (StringUtils.isBlank(vo.getCode())) {
			throw new BusinessProjectException("短信验证码错误");
		}

		greememberComponent.register(vo.getAccount(), vo.getPassword(), vo.getCode());
	}

	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	@ResponseBody
	public void sendCode(HttpSession session, @RequestBody SendCodeVo vo) throws Exception {

		// 判断图片验证码是否正确
		// TODO captcha 跟着session走 后续改成中间件存储

		String captcha0 = (String) session.getAttribute("captcha");

		session.removeAttribute("captcha");

		String captcha = vo.getCaptcha() + "";

		// if (!captcha.equals(captcha0)) {
		// throw new CaptchaErrorProjectException();
		// }

		switch (vo.getType()) {
		case 0:
			greememberComponent.sendCode(vo.getTel());
			break;
		case 1:
			greememberComponent.sendCode4ForgetPassword(vo.getTel());
			break;
		default:
			break;
		}

	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ResponseBody
	public void resetPassword(@RequestBody RegisterUserVo vo) throws Exception {
		greememberComponent.resetPassword(vo.getAccount(), vo.getCode(), vo.getPassword());
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void captcha(HttpSession session, HttpServletResponse response) throws Exception {

		// TODO captcha 跟着session走 后续改成中间件存储

		WebCaptcha captcha = captchaWebService.create(4, 50);

		session.setAttribute("captcha", captcha.getCode());

		response.setContentType("image/jpeg");
		response.setHeader("cache", "no-cache");

		OutputStream os = response.getOutputStream();

		os.write(captcha.getImage());

		try {
			os.flush();
		} finally {
			os.close();
		}

	}
}
