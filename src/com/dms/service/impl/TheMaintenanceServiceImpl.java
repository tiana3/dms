package com.dms.service.impl;

import java.util.List;

import com.dms.dao.OrdersDao;
import com.dms.dao.RepairTypeDao;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.TheMaintenanceService;

public class TheMaintenanceServiceImpl implements TheMaintenanceService {

	private OrdersDao ordersDao;
	private RepairTypeDao repairTypeDao;
	
	public static void main(String[] args) {
		TheMaintenanceServiceImpl imp = new TheMaintenanceServiceImpl();
		imp.getAllRepairType();
	}
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> order = ordersDao.getAllOrders();
		return order;
	}
	
	@Override
	public List<RepairType> getAllRepairType() {
		List<RepairType> repairType = repairTypeDao.getAllRepairType();
		return repairType;
	}
	
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public RepairTypeDao getRepairTypeDao() {
		return repairTypeDao;
	}

	public void setRepairTypeDao(RepairTypeDao repairTypeDao) {
		this.repairTypeDao = repairTypeDao;
	}



}
