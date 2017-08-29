package com.dms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.OrderIdBuildDao;

public class OrderIdBuildDaoImpl implements OrderIdBuildDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public Integer getCurrentNum() {
		OrderIdBuildDao mapper = sqlSessionTemplate.getMapper(OrderIdBuildDao.class);
		Integer currentNum = mapper.getCurrentNum();
		return currentNum;
	}

	@Override
	public void updateNum(Integer num) {
		OrderIdBuildDao mapper = sqlSessionTemplate.getMapper(OrderIdBuildDao.class);
		mapper.updateNum(num);
	}

}
