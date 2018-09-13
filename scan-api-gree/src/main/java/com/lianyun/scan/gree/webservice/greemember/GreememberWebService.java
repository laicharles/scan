package com.lianyun.scan.gree.webservice.greemember;

import java.util.List;

import com.lianyun.scan.gree.webservice.greemember.model.respond.CheckRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.PlatformRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfoRespond;

public interface GreememberWebService {

	List<PlatformRespond> listPlatforms();

	boolean register(String tel, String password, String code, int platformId);

	LoginRespond login(String account, String password, int platformId);

	LoginRespond refresh(String token);

	boolean sendCode(String tel);

	boolean sendCode4ForgetPassword(String tel, String token);

	CheckRespond check(String account);

	boolean resetPassword(String account, String token, String code, String password);

	UserInfoRespond getUserInfo(String token);

	boolean verifyCode(String tel, String code);

}
