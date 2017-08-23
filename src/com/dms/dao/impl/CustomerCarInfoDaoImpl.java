package com.dms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.entity.CustomerCarInfo;

public class CustomerCarInfoDaoImpl implements CustomerCarInfoDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String key) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		CustomerCarInfo customerCarInfo = mapper.getCustomerCarInfoByKey(key);
		return customerCarInfo;
	}

}
