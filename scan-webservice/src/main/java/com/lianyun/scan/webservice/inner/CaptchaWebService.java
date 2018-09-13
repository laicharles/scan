package com.lianyun.scan.webservice.inner;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lianyun.scan.webservice.inner.config.FeignAuthConfiguration;
import com.lianyun.scan.webservice.inner.model.WebCaptcha;

@FeignClient(value = "captcha", path = "/create", configuration = FeignAuthConfiguration.class)
public interface CaptchaWebService {

	@RequestMapping(method = RequestMethod.GET)
	WebCaptcha create(@RequestParam("length") int length, @RequestParam(value = "height") int height);

}
