package com.lianyun.scan.admin.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianyun.scan.frame.model.ControllerMethod;
import com.lianyun.scan.model.AdminOperation;

/**
 * @author 560133
 *
 *         操作日志
 *
 */
@Controller
@RequestMapping(value = "/admin/operations")
public class OperationAdminController extends AbstractController<Long, AdminOperation> {

	@Override
	protected Collection<ControllerMethod> noSupportMethodNames() {
		Set<ControllerMethod> noSupportMethodNames = new HashSet<>();
		noSupportMethodNames.add(ControllerMethod.DELETE);
		noSupportMethodNames.add(ControllerMethod.WORK);
		noSupportMethodNames.add(ControllerMethod.ADD);
		noSupportMethodNames.add(ControllerMethod.GET);

		return noSupportMethodNames;
	}

}
