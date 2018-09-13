package com.lianyun.scan.enterprise.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lianyun.scan.exception.NoLoginProjectException;

public class EnterpriseConfig implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("userLogin") == null) {
			throw new NoLoginProjectException();
		}
		return true;
	}
}
