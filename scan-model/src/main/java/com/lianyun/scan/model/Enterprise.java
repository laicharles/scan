package com.lianyun.scan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.lianyun.scan.frame.model.Name;
import com.lianyun.scan.model.abs.EnterpriseStatus;
import com.lianyun.scan.util.json.strategy.ListHide;

/**
 * 企业
 * 
 * @author 560133
 *
 */
public class Enterprise extends Name {

	@Expose
	@ListHide
	private String logo;

	@Expose
	@ListHide
	private String address;

	@Expose
	@ListHide
	private String corporation;

	@Expose
	private Date startTime = new Date();

	@Expose
	private Date endTime = new Date();

	private EnterpriseStatus status = EnterpriseStatus.NORMAL;

	@ListHide
	@Expose
	private List<SubsystemCheck> subsystems;

	{
		subsystems = new ArrayList<>();
		subsystems.add(new SubsystemCheck());
		subsystems.add(new SubsystemCheck());
		subsystems.add(new SubsystemCheck());
	}

	@ListHide
	private List<SubsystemCheck> selfSubsystems;

	{
		selfSubsystems = new ArrayList<>();
		selfSubsystems.add(new SubsystemCheck());
		selfSubsystems.add(new SubsystemCheck());
		selfSubsystems.add(new SubsystemCheck());
	}

	@Expose
	private List<EnterpriseContact> contacts;

	{
		contacts = new ArrayList<>();
		contacts.add(new EnterpriseContact());
		contacts.add(new EnterpriseContact());
	}

	// private List<Employee> employees;
	//
	// public Enterprise init() {
	//
	// {
	// employees = new ArrayList<>();
	// employees.add(new Employee());
	// employees.add(new Employee());
	// employees.add(new Employee());
	// }
	//
	// return this;
	// }

}
