package com.lianyun.scan.gree.enterprise.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.frame.model.ControllerMethod;
import com.lianyun.scan.gree.model.GreeKind;
import com.lianyun.scan.gree.model.condition.GreeKindPageCondition;

/**
 * @author 560133
 *
 *         二级分类
 *
 */
@Controller
@RequestMapping(value = "/enterprise/kind")
public class KindGreeEnterpriseController
		extends AbstractGreeEnterpriseController<Long, GreeKind, GreeKindPageCondition> {

	@Override
	protected Collection<ControllerMethod> noSupportMethodNames() {
		Set<ControllerMethod> noSupportMethodNames = new HashSet<>();
		noSupportMethodNames.add(ControllerMethod.DELETE);
		noSupportMethodNames.add(ControllerMethod.WORK);
		noSupportMethodNames.add(ControllerMethod.ADD);
		return noSupportMethodNames;
	}

}
