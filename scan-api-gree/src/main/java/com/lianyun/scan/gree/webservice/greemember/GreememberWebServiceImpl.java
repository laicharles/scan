package com.lianyun.scan.gree.webservice.greemember;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lianyun.scan.gree.webservice.greemember.GreememberWebUtil.RequestResult;
import com.lianyun.scan.gree.webservice.greemember.model.request.AccountSignRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.CodeSignRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.ForgetPasswordCodeSignRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.LoginRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.RegisterRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.ResetPasswordRequest;
import com.lianyun.scan.gree.webservice.greemember.model.request.TelSignRequest;
import com.lianyun.scan.gree.webservice.greemember.model.respond.BooleanGreememberRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.CheckGreememberRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.CheckRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.ListPlatformGreememberRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginGreememberRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.LoginRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.PlatformRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfoGreememberRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfoRespond;
import com.lianyun.scan.gree.webservice.greemember.model.respond.ValidGreememberRespond;
import com.lianyun.scan.util.JsonUtil;

@Component
public class GreememberWebServiceImpl implements GreememberWebService {

	@Override
	public List<PlatformRespond> listPlatforms() {

		String url = "https://member.gree.com/accountapi/api/get/platformtype/list";

		RequestResult<ListPlatformGreememberRespond> requestResult = GreememberWebUtil.get(url, 1000,
				ListPlatformGreememberRespond.class);
		return requestResult.getBody().getRealData();
	}

	@Override
	public LoginRespond login(String account, String password, int platformId) {

		String url = "https://member.gree.com/accountapi/api/login?clientid=82a38c0f-7848-4212-b7eb-a8eadb718a58";

		LoginRequest request = new LoginRequest(account, password, platformId);

		RequestResult<LoginGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				LoginGreememberRespond.class);

		return requestResult.getBody().getRealData();
	}

	public static void main(String[] args) {

		System.out.println(JsonUtil.toJson(new GreememberWebServiceImpl().login("13411558121", "123456", 0)));

	}

	@Override
	public boolean register(String tel, String password, String code, int platformId) {

		String url = "https://member.gree.com/accountapi/api/mergeuser/register";

		RegisterRequest request = new RegisterRequest(tel, password, code, platformId);

		RequestResult<BooleanGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				BooleanGreememberRespond.class);

		return requestResult.getBody().getRealData().isSuccess();
	}

	@Override
	public LoginRespond refresh(String token) {

		String url = "https://member.gree.com/accountapi/api/refresh";

		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Refresh " + token);

		RequestResult<LoginGreememberRespond> requestResult = GreememberWebUtil.post(url, Collections.emptyMap(), 1000,
				headers, LoginGreememberRespond.class);

		return requestResult.getBody().getRealData();

	}

	@Override
	public boolean sendCode(String tel) {

		String url = "https://member.gree.com/accountapi/api/send/tel/vcode";

		TelSignRequest request = new TelSignRequest(tel);

		RequestResult<BooleanGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				BooleanGreememberRespond.class);

		return requestResult.getBody().getRealData().isSuccess();
	}

	@Override
	public CheckRespond check(String account) {

		String url = "https://member.gree.com/accountapi/api/check/account";

		AccountSignRequest request = new AccountSignRequest(account);

		RequestResult<CheckGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				CheckGreememberRespond.class);

		return requestResult.getBody().getRealData();
	}

	@Override
	public boolean resetPassword(String account, String token, String code, String password) {

		String url = "https://member.gree.com/accountapi/api/token/alter/password";

		AccountSignRequest request = new ResetPasswordRequest(account, token, code, password);

		RequestResult<BooleanGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				BooleanGreememberRespond.class);

		return requestResult.getBody().getRealData().isSuccess();
	}

	@Override
	public UserInfoRespond getUserInfo(String token) {

		String url = "https://member.gree.com/accountapi/api/get/user/info";

		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Bearer " + token);

		RequestResult<UserInfoGreememberRespond> requestResult = GreememberWebUtil.get(url, 1000, headers,
				UserInfoGreememberRespond.class);

		return requestResult.getBody().getRealData();

	}

	@Override
	public boolean sendCode4ForgetPassword(String tel, String token) {

		String url = "https://member.gree.com/accountapi/api/send/tel/forget/token";

		ForgetPasswordCodeSignRequest request = new ForgetPasswordCodeSignRequest(tel, token);

		RequestResult<BooleanGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				BooleanGreememberRespond.class);

		return requestResult.getBody().getRealData().isSuccess();

	}

	@Override
	public boolean verifyCode(String tel, String code) {

		String url = "https://member.gree.com/accountapi/api/verify/tel/vcode";

		CodeSignRequest request = new CodeSignRequest(tel, code);

		RequestResult<ValidGreememberRespond> requestResult = GreememberWebUtil.post(url, request, 1000,
				ValidGreememberRespond.class);

		return requestResult.getBody().getRealData().isValid();

	}

}
