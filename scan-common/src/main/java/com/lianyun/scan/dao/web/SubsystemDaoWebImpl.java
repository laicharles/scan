package com.lianyun.scan.dao.web;

import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.BaseDaoWebImpl;
import com.lianyun.scan.model.Subsystem;
import com.lianyun.scan.webservice.inner.model.WebPlugin;

@Repository
public class SubsystemDaoWebImpl extends BaseDaoWebImpl<Long, Subsystem, WebPlugin> {

	@Override
	protected WebPlugin toOut0(Subsystem in) {
		
		WebPlugin plugin = new WebPlugin();
		plugin.setId(in.getId());
		plugin.setName(in.getName());
		plugin.setCreateTime(in.getCreateTime());
		plugin.setDesc(in.getDesc());
		plugin.setHealthUrl(in.getHealthUrl());
		plugin.setLogo(in.getLogo());
		plugin.setSecretKey(in.getSecretkey());
		plugin.setUpdateTime(in.getUpdateTime());
		plugin.setUrl(in.getUrl());
		plugin.setWork(in.isWork());
		return plugin;
	}

	@Override
	protected Subsystem toIn0(WebPlugin out) {
		Subsystem subsystem = new Subsystem();
		subsystem.setId(out.getId());
		subsystem.setName(out.getName());
		subsystem.setCreateTime(out.getCreateTime());
		subsystem.setDesc(out.getDesc());
		subsystem.setHealthUrl(out.getHealthUrl());
		subsystem.setLogo(out.getLogo());
		subsystem.setSecretkey(out.getSecretKey());
		subsystem.setUpdateTime(out.getUpdateTime());
		subsystem.setUrl(out.getUrl());
		subsystem.setWork(out.isWork());

		return subsystem;
	}

}
