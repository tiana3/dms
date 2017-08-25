package com.dms.dao.impl;

import java.util.List;

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

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
