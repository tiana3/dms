package com.dms.dao.impl;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.OrderDao;
import com.dms.entity.Custom;
import com.dms.entity.Order;
import com.dms.entity.Part;


public class TheMaintenanceDaoImpl implements OrderDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<Order> getAllOrders() {
		OrderDao dao = (OrderDao) sqlSessionTemplate.getMapper(OrderDao.class);
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

	@Override
	public Order getLastOrder(String plateNumber, String VIN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustoms(String orderId, List<Custom> customs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParts(String orderId, List<Part> parts) {
		// TODO Auto-generated method stub
		
	}
}
