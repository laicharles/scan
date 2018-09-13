package com.lianyun.scan.web.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.lianyun.scan.exception.ProjectException;
import com.lianyun.scan.exception.Result;

@ControllerAdvice
public class ExceptionAdvice implements ResponseBodyAdvice<Object> {

	protected static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public Object handException(HttpServletRequest request, Exception e) throws Exception {

		if (e instanceof ProjectException) {
			ProjectException pe = (ProjectException) e;
			return pe.toResult();
		}
		logger.warn(request.getRequestURI() + " error:", e);
		return new Result(5, e.getMessage(), null);
	}

	@Override
	@ResponseBody
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		if (body != null && body instanceof Result) {
			return body;
		}

		Result result = new Result(body);
		

		return result;
	}

}
