package com.dms.service.impl;

import java.util.List;

import com.dms.dao.OrdersDao;
import com.dms.entity.Order;
import com.dms.service.TheMaintenanceService;

public class TheMaintenanceServiceImpl implements TheMaintenanceService {

	private OrdersDao ordersDao;
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> order = ordersDao.getAllOrders();
		return order;
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

}
