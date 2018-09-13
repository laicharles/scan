package com.lianyun.scan.webservice.inner.imp;

import org.springframework.stereotype.Component;

import com.lianyun.scan.frame.BaseWebServiceImpl;
import com.lianyun.scan.webservice.inner.model.WebPlugin;

@Component
public class PluginWebServiceImp extends BaseWebServiceImpl<Long, WebPlugin> {

	@Override
	protected String host() {
		return "plugin";
	}

	@Override
	protected String path() {
		return "v1/plugins";
	}

}
