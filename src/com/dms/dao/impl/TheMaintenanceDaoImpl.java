package com.dms.dao.impl;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.OrdersDao;
import com.dms.entity.Order;


public class TheMaintenanceDaoImpl implements OrdersDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<Order> getAllOrders() {
		OrdersDao dao = sqlSessionTemplate.getMapper(OrdersDao.class);
		List<Order> order = dao.getAllOrders();
		return order;
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
