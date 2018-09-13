package com.lianyun.scan.gree.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.DbDao;
import com.lianyun.scan.gree.dao.GreeCategoryDao;
import com.lianyun.scan.gree.model.GreeCategory;

@Repository
public interface GreeCategoryDaoDbImpl extends DbDao<Long, GreeCategory>, GreeCategoryDao {

	@Query("select t from GreeCategory t where t.code=:code")
	GreeCategory getByCode(@Param("code") String code);

}
