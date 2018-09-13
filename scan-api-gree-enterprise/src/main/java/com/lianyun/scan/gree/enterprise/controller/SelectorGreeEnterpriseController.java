package com.lianyun.scan.gree.enterprise.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.frame.IService;
import com.lianyun.scan.frame.model.Context;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.frame.model.Selector;
import com.lianyun.scan.frame.util.SelectorUtil;
import com.lianyun.scan.gree.model.GreeCategory;
import com.lianyun.scan.gree.model.GreeEmployee;
import com.lianyun.scan.model.Enterprise;
import com.lianyun.scan.model.EnterpriseAuth;
import com.lianyun.scan.model.EnterpriseRole;
import com.lianyun.scan.util.ContextUtil;

@Controller
@RequestMapping(value = "/enterprise/selector")
public class SelectorGreeEnterpriseController {

	@ModelAttribute
	private void setContext(HttpSession session) {

		//TODO  Enterprise enterprise = SessionUtil.getEnterprise(session);
		Enterprise enterprise = new Enterprise();
		enterprise.setId(1L);
		Context context = new Context();
		context.getParams().put("enterpriseId", enterprise.getId());
		ContextUtil.setContext(context);

	}
	
	private PageCondition PAGE_CONDITION = new PageCondition();
	{
		PAGE_CONDITION.setPage(1);
		PAGE_CONDITION.setSize(10000);
	}
	
	@Autowired
	private IService<Long, EnterpriseAuth> enterpriseAuthService;

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> auth() throws Exception {
		
		List<EnterpriseAuth> vs = enterpriseAuthService.list(PAGE_CONDITION);
		return SelectorUtil.toSelector(vs);
	}
	
	@Autowired
	private IService<Long, EnterpriseRole> enterpriseRoleService;
	
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> role() throws Exception {
		List<EnterpriseRole> vs = enterpriseRoleService.list(PAGE_CONDITION);
		return SelectorUtil.toSelector(vs);
	}
	
	@Autowired
	private IService<Long, GreeEmployee> greeEmployeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> employee() throws Exception {
		List<GreeEmployee> vs = greeEmployeeService.list(PAGE_CONDITION);
		return SelectorUtil.toSelector(vs);
	}	
	
	@Autowired
	private IService<Long, GreeCategory> greeCategoryService;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	@ResponseBody
	public List<Selector> category() throws Exception {
		List<GreeCategory> vs = greeCategoryService.list(PAGE_CONDITION);
		return SelectorUtil.toSelector(vs);
	}		
	
	
	

}
