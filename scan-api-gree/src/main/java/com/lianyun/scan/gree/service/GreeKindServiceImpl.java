package com.lianyun.scan.gree.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lianyun.scan.exception.IdNoFoundProjectException;
import com.lianyun.scan.frame.BaseServiceImpl;
import com.lianyun.scan.frame.IDao;
import com.lianyun.scan.gree.model.GreeKind;
import com.lianyun.scan.model.Subsystem;

@Service
public class GreeKindServiceImpl extends BaseServiceImpl<Long, GreeKind> {

	@Autowired
	private IDao<Long, Subsystem> subsystemDao;

	@Override
	public GreeKind get(Long k) {
		GreeKind greeKind = super.get(k);

		ArrayList<Subsystem> subsystems = new ArrayList<>();
		Set<Long> subsystemIds = greeKind.getSubsystemIds();
		for (Long subsystemId : subsystemIds) {
			Subsystem subsystem = subsystemDao.get(subsystemId);
			if (subsystem != null) {
				subsystems.add(subsystem);
			}

		}
		greeKind.setSubsystems(subsystems);
		return greeKind;

	}

	@Override
	public boolean edit(Long id, GreeKind greeKind) {
		GreeKind greeKind0 = super.get(greeKind.getId());
		if (greeKind0 == null) {
			throw new IdNoFoundProjectException(id);
		}

		List<Subsystem> subsystems = greeKind.getSubsystems();
		Set<Long> subsystemIds = new HashSet<>();
		for (Subsystem subsystem : subsystems) {
			subsystemIds.add(subsystem.getId());
		}

		greeKind0.setSubsystemIds(subsystemIds);
		return super.edit(id, greeKind0);
	}

}
