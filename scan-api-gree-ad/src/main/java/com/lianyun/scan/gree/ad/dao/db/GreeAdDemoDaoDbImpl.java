package com.lianyun.scan.gree.ad.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.DbDao;
import com.lianyun.scan.gree.ad.dao.GreeAdDemoDao;
import com.lianyun.scan.gree.ad.model.GreeAdDemo;

@Repository
public interface GreeAdDemoDaoDbImpl extends DbDao<Long, GreeAdDemo>, GreeAdDemoDao {

	@Query("select t from GreeAdDemo t where t.name=:name")
	GreeAdDemo getByName(@Param("name") String name);

}
