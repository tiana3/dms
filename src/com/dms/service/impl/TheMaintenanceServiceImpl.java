package com.dms.service.impl;

import java.util.List;

import com.dms.dao.OrderDao;
import com.dms.entity.Order;
import com.dms.service.TheMaintenanceService;

public class TheMaintenanceServiceImpl implements TheMaintenanceService {

	private OrderDao ordersDao;
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> order = ordersDao.getAllOrders();
		return order;
	}

	public OrderDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrderDao ordersDao) {
		this.ordersDao = ordersDao;
	}

}
