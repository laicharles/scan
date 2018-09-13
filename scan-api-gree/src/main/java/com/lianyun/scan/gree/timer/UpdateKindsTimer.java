package com.lianyun.scan.gree.timer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lianyun.scan.gree.dao.imp.GreeCategoryDaoImp;
import com.lianyun.scan.gree.dao.imp.GreeKindDaoImp;
import com.lianyun.scan.gree.model.GreeCategory;
import com.lianyun.scan.gree.model.GreeKind;
import com.lianyun.scan.gree.webservice.greeimage.GreeimageWebService;
import com.lianyun.scan.gree.webservice.greeimage.model.respond.GreeimageCategory;
import com.lianyun.scan.timer.Timer;

@Component
public class UpdateKindsTimer extends Timer {

	protected static Logger logger = LoggerFactory.getLogger(UpdateKindsTimer.class);

	@Autowired
	private GreeimageWebService greeimageWebService;

	@Autowired
	private GreeCategoryDaoImp greeCategoryDao;

	@Autowired
	private GreeKindDaoImp greeKindDao;

	//TODO @Scheduled(cron = "0 * * * * *")
	public void scheduled() {
		super.start("更新分类");
	}

	@Override
	public void run() {
		List<GreeimageCategory> greeimageCategories = greeimageWebService.listCategorys();
		for (GreeimageCategory greeimageCategory : greeimageCategories) {

			String code = greeimageCategory.getCode();

			GreeCategory greeCategory = greeCategoryDao.getByCode(code);

			if (greeCategory == null) {
				greeCategory = new GreeCategory();
			}
			greeCategory.setCode(code);
			greeCategory.setName(greeimageCategory.getName());

			List<GreeKind> greeKinds = new ArrayList<>();
			greeCategory.setGreeKinds(greeKinds);

			List<GreeimageCategory> greeimageCategories2 = greeimageCategory.getChildren();
			for (GreeimageCategory greeimageCategory2 : greeimageCategories2) {

				String code2 = greeimageCategory2.getCode();
				GreeKind greeKind = greeKindDao.getByCode(code2);
				if (greeKind == null) {
					greeKind = new GreeKind();
				}

				greeKind.setCode(code2);
				greeKind.setName(greeimageCategory2.getName());

				greeKinds.add(greeKind);

			}
 
			greeCategoryDao.add(greeCategory);

		}

	}

}
