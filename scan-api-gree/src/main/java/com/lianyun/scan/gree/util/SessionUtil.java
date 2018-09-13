package com.lianyun.scan.gree.util;

import javax.servlet.http.HttpSession;

import com.lianyun.scan.gree.model.GreeEmployee;
import com.lianyun.scan.gree.webservice.greemember.model.respond.UserLogin;
import com.lianyun.scan.model.Enterprise;

public class SessionUtil {

	private static final String USER_LOGIN_KEY = "userLogin";
	private static final String ENTERPRISE_KEY = "enterprise";
	private static final String EMPLOYEE_KEY = "employee";

	public static void setUserLogin(HttpSession session, UserLogin userLogin) {
		session.setAttribute(USER_LOGIN_KEY, userLogin);
	}

	public static UserLogin getUserLogin(HttpSession session) {
		return (UserLogin) session.getAttribute(USER_LOGIN_KEY);
	}

	public static void setEnterprise(HttpSession session, Enterprise enterprise) {
		session.setAttribute(ENTERPRISE_KEY, enterprise);
	}

	public static Enterprise getEnterprise(HttpSession session) {
		return (Enterprise) session.getAttribute(ENTERPRISE_KEY);
	}

	public static void setEmployee(HttpSession session, GreeEmployee employee) {
		session.setAttribute(EMPLOYEE_KEY, employee);
	}

	public static GreeEmployee getEmployee(HttpSession session) {
		return (GreeEmployee) session.getAttribute(EMPLOYEE_KEY);

	}

}
