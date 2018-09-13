package com.lianyun.scan.gree.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.DbDao;
import com.lianyun.scan.gree.dao.GreeKindDao;
import com.lianyun.scan.gree.model.GreeKind;

@Repository
public interface GreeKindDaoDbImpl extends DbDao<Long, GreeKind>, GreeKindDao {

	@Query("select t from GreeKind t where t.code=:code")
	GreeKind getByCode(@Param("code") String code);

}
