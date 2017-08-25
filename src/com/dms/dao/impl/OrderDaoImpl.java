package com.dms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.OrderDao;
import com.dms.entity.Order;

public class OrderDaoImpl implements OrderDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public Order getLastOrder(String plateNumber, String VIN) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		return mapper.getLastOrder(plateNumber, VIN);
	}

}
