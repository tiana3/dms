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
			String plateNumber, String orderId) {
			List<Order> order = orderDao.getSettlementByWordKey(completedDate, SA,  plateNumber, orderId);
			return order; 
	}

	@Override
	public List<Employee> getSA() {
		List<Employee> employee =employeeDao.getSA();		
		return employee;
	}

	@Override
	public Order getOrderById(String orderId) {
		Order order = orderDao.getOrderById(orderId);
		return order;
	}

	@Override

	public List<Order> getSettlementByOrderStateId(String settlementDate, Integer SA, String plateNumber,
			String orderId) {
		List<Order> order = orderDao.getSettlementByOrderStateId(settlementDate, SA, plateNumber, orderId);
		return order; 
	}

	public void deleteWorkout(String orderId) {
		// TODO Auto-generated method stub
		orderDao.deleteWorkout(orderId);
	}

	@Override
	public void updateOrderStateId(String orderId) {
		orderDao.updateOrderStateId(orderId);
		
	}

}
