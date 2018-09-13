package com.lianyun.scan.gree.webservice.greemember.component;

import java.util.List;

import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.PlatformRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfo;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;

public interface GreememberComponent {

	List<PlatformRespond> listPlatforms();

	boolean register(String tel, String password, String code);

	LoginRespond login(String account, String password, int platformId);

	boolean sendCode(String tel);

	boolean sendCode4ForgetPassword(String tel);

	boolean resetPassword(String account, String code, String password);

	UserInfo getUserInfo(UserLogin userLogin);

}
