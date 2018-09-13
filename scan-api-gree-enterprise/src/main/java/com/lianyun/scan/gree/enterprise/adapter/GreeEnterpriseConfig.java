package com.lianyun.scan.gree.enterprise.adapter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lianyun.scan.exception.NoLoginProjectException;
import com.lianyun.scan.exception.NoPowerProjectException;
import com.lianyun.scan.gree.dao.imp.GreeEmployeeDaoImp;
import com.lianyun.scan.gree.model.GreeEmployee;
import com.lianyun.scan.gree.util.SessionUtil;
import com.lianyun.scan.gree.webservice.greemember.component.GreememberComponent;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserInfo;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;
import com.lianyun.scan.model.EnterpriseAuth;
import com.lianyun.scan.model.EnterpriseRole;

public class GreeEnterpriseConfig implements HandlerInterceptor {

	@Autowired
	private GreeEmployeeDaoImp greeEmployeeDaoImp;

	@Autowired
	private GreememberComponent greememberComponent;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		String uri = httpServletRequest.getRequestURI();

		// 判断是否有权限访问系统 根据角色判断是否有权限访问接口

		HttpSession session = httpServletRequest.getSession();

		GreeEmployee employee = SessionUtil.getEmployee(session);

		List<EnterpriseRole> roles = null;

		if (employee == null) {

			UserLogin userLogin = SessionUtil.getUserLogin(session);

			if (userLogin == null) {
				throw new NoLoginProjectException();
			}

			long userId = userLogin.getLoginRespond().getUserId();

			GreeEmployee greeEmployee = greeEmployeeDaoImp.getByUserIdOrTel(userId, null);

			if (greeEmployee == null) {
				UserInfo info = greememberComponent.getUserInfo(userLogin);

				if (info == null) {
					throw new NoLoginProjectException();
				}

				String tel = info.getTel();
				greeEmployee = greeEmployeeDaoImp.getByUserIdOrTel(userId, tel);

				if (greeEmployee == null) {
					throw new NoPowerProjectException();
				}

				greeEmployee.setUserId(userId);
				greeEmployeeDaoImp.add(greeEmployee);
			}

			roles = greeEmployee.getRoles();
			SessionUtil.setEmployee(session, greeEmployee);
			employee = greeEmployee;
		} else {
			roles = employee.getRoles();
		}

		for (EnterpriseRole enterpriseRole : roles) {
			List<EnterpriseAuth> auths = enterpriseRole.getAuths();
			for (EnterpriseAuth enterpriseAuth : auths) {
				String refer = enterpriseAuth.getRefer();
				Matcher m = Pattern.compile(refer).matcher(uri);
				if (m.matches()) {
					return true;
				}
			}
		}

		throw new NoPowerProjectException();
	}
}
