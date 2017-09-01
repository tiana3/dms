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
	public String getCurrentNum() {                          
		OrderIdBuildDao mapper = sqlSessionTemplate.getMapper(OrderIdBuildDao.class);
		String currentNum = mapper.getCurrentNum();
		return currentNum;
	}

	@Override
	public void updateNum(String num) {
		OrderIdBuildDao mapper = sqlSessionTemplate.getMapper(OrderIdBuildDao.class);
		mapper.updateNum(num);
	}

}
