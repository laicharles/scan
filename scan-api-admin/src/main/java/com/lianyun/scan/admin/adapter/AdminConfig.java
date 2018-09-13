package com.lianyun.scan.admin.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.lianyun.scan.exception.NoLoginProjectException;

public class AdminConfig implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		//TODO 判断是否有权限访问系统
				
		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("userLogin") == null) {
			throw new NoLoginProjectException();
		}
		return true;
	}
}
