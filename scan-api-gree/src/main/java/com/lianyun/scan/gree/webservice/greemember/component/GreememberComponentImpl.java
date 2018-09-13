package com.lianyun.scan.gree.webservice.greemember.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lianyun.scan.exception.BusinessProjectException;
import com.lianyun.scan.gree.webservice.greemember.GreememberWebService;
import com.lianyun.scan.gree.webservice.greemember.model.respond.CheckRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.PlatformRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfo;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;

@Component
public class GreememberComponentImpl implements GreememberComponent {

	@Autowired
	private GreememberWebService greememberWebService;

	@Override
	public List<PlatformRespond> listPlatforms() {
		return greememberWebService.listPlatforms();
	}

	@Override
	public boolean register(String tel, String password, String code) {

		boolean valid = greememberWebService.verifyCode(tel, code);

		if (!valid) {
			throw new BusinessProjectException("短信验证码错误");
		}

		return greememberWebService.register(tel, password, code, 0);
	}

	@Override
	public LoginRespond login(String account, String password, int platformId) {
		return greememberWebService.login(account, password, platformId);
	}

	@Override
	public boolean sendCode(String tel) {
		return greememberWebService.sendCode(tel);
	}

	@Override
	public boolean resetPassword(String account, String code, String password) {

		CheckRespond respond = greememberWebService.check(account);
		return greememberWebService.resetPassword(account, respond.getToken(), code, password);

	}

	@Override
	public UserInfo getUserInfo(UserLogin userLogin) {

		LoginRespond loginRespond = userLogin.getLoginRespond();

		try {
			String token = loginRespond.getToken();
			return greememberWebService.getUserInfo(token).getUserInfo();
		} catch (Exception e) {
			loginRespond = greememberWebService.refresh(loginRespond.getRefreshToken());
			userLogin.setLoginRespond(loginRespond);
			userLogin.setChange(true);
		}

		return greememberWebService.getUserInfo(loginRespond.getToken()).getUserInfo();

	}

	@Override
	public boolean sendCode4ForgetPassword(String tel) {
		CheckRespond respond = greememberWebService.check(tel);
		return greememberWebService.sendCode4ForgetPassword(tel, respond.getToken());
	}

}
