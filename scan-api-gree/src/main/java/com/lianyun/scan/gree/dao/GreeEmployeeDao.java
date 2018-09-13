package com.lianyun.scan.gree.dao;

import com.lianyun.scan.gree.model.GreeEmployee;

public interface GreeEmployeeDao {

	GreeEmployee getByUserIdOrTel(Long userId, String tel);

}
