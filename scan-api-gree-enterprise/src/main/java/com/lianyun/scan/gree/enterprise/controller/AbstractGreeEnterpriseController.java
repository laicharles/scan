package com.lianyun.scan.gree.enterprise.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.lianyun.scan.frame.model.Context;
import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.gree.controller.CurdController;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.util.ContextUtil;

public abstract class AbstractGreeEnterpriseController<K, V extends IdAble<K>, P extends PageCondition>
		extends CurdController<K, V, P> {

	@ModelAttribute
	private void setContext(HttpSession session) {

		//TODO  Enterprise enterprise = SessionUtil.getEnterprise(session);
		Enterprise enterprise = new Enterprise();
		enterprise.setId(1L);
		Context context = new Context();
		context.getParams().put("enterpriseId", enterprise.getId());
		ContextUtil.setContext(context);

	}

}
