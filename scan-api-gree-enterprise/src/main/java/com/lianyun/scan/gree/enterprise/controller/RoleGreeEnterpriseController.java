package com.lianyun.scan.gree.enterprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.model.EnterpriseRole;

/**
 * @author 560133
 *
 *         角色
 *
 */
@Controller
@RequestMapping(value = "/enterprise/role")
public class RoleGreeEnterpriseController
		extends AbstractGreeEnterpriseController<Long, EnterpriseRole, PageCondition> {

}
