package com.lianyun.scan.gree.dao.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lianyun.scan.frame.DbDao;
import com.lianyun.scan.gree.dao.GreeEmployeeDao;
import com.lianyun.scan.gree.model.GreeEmployee;

@Repository
public interface GreeEmployeeDaoDbImpl extends DbDao<Long, GreeEmployee>, GreeEmployeeDao {

	@Query("select t from GreeEmployee t where t.userId=:userId or t.tel=:tel")
	GreeEmployee getByUserIdOrTel(@Param("userId") Long userId, @Param("tel") String tel);

}
