package com.dms.service.impl;

import java.util.List;

import com.dms.dao.EmployeeDao;
import com.dms.dao.OrderDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.service.SettlementService;

public class SettlementServiceImpl implements SettlementService {
	
	private OrderDao orderDao ;
	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getSettlementByWordKey(String completedDate, Integer SA, 
			String customerCarInfo, String orderId) {
			List<Order> order = orderDao.getSettlementByWordKey(completedDate, SA,  customerCarInfo, orderId);
			return order; 
	}

	@Override
	public List<Employee> getSA() {
		List<Employee> employee =employeeDao.getSA();		
		return employee;
	}




}
