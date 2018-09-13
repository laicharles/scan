package com.lianyun.scan.gree.enterprise.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianyun.scan.frame.model.ControllerMethod;
import com.lianyun.scan.frame.model.IdAble;
import com.lianyun.scan.frame.model.PageCondition;
import com.lianyun.scan.model.Notice;

/**
 * @author 560133
 *
 *         消息
 *
 */
@Controller
@RequestMapping(value = "/enterprise/notice")
public class NoticeGreeEnterpriseController extends AbstractGreeEnterpriseController<Long, Notice, PageCondition> {
	// TODO

	// 已读

	@Override
	protected Collection<ControllerMethod> noSupportMethodNames() {
		Set<ControllerMethod> noSupportMethodNames = new HashSet<>();
		noSupportMethodNames.add(ControllerMethod.ADD);
		noSupportMethodNames.add(ControllerMethod.WORK);

		return noSupportMethodNames;
	}

	@RequestMapping(value = "/multiRead", method = RequestMethod.POST)
	@ResponseBody
	public final void multiRead(List<IdAble<Long>> ids) {

		for (IdAble<Long> id : ids) {

			Notice notice = this.get0(id.getId());
			if (notice == null) {
				continue;
			}
			notice.setRead(true);
			this.edit0(notice.getId(), notice);
		}

	}

}
