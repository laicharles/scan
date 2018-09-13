package com.lianyun.scan.gree.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lianyun.scan.exception.NoLoginProjectException;
import com.lianyun.scan.gree.util.SessionUtil;

public class GreeMemberConfig implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		HttpSession session = httpServletRequest.getSession();

		if (SessionUtil.getUserLogin(session) == null) {
			throw new NoLoginProjectException();
		}
		return true;
	}
}
