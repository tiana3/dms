package com.dms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.OrderDao;
import com.dms.entity.Custom;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;

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
	
	/**
	 * 添加新订单，保存基本信息，和所有工时和所有材料
	 */
	@Transactional
	@Override
	public void addOrder(Order order) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addOrder(order);
		
		List<Custom> customs = order.getCustoms();
		List<Part> parts = order.getParts();
		if(customs != null) {
			addCustoms(order.getOrderId(), customs);
		}
		if (parts != null) {
			addParts(order.getOrderId(), parts);
		}
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustoms(String orderId, List<Custom> customs) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addCustoms(orderId, customs);
	}

	@Override
	public void addParts(String orderId, List<Part> parts) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addParts(orderId, parts);
	}

	@Override
	public List<Employee> getSA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders(String plateNumber, int employeeId, int repairId) {
		// TODO Auto-generated method stub
		return null;
	}

}
