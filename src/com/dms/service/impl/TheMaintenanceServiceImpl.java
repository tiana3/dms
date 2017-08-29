package com.dms.service.impl;

import java.util.List;


import com.dms.dao.RepairTypeDao;

import com.dms.dao.OrderDao;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.TheMaintenanceService;

public class TheMaintenanceServiceImpl implements TheMaintenanceService {


	private OrderDao orderDao;
	private RepairTypeDao repairTypeDao;
	
	public static void main(String[] args) {
		TheMaintenanceServiceImpl imp = new TheMaintenanceServiceImpl();
		imp.getAllRepairType();
	}



	
	@Override
	public List<RepairType> getAllRepairType() {
		List<RepairType> repairType = repairTypeDao.getAllRepairType();
		return repairType;
	}
	



	public OrderDao getOrdersDao() {

		return orderDao;
	}

	public void setOrdersDao(OrderDao ordersDao) {
		this.orderDao = ordersDao;
	}

	public RepairTypeDao getRepairTypeDao() {
		return repairTypeDao;
	}

	public void setRepairTypeDao(RepairTypeDao repairTypeDao) {
		this.repairTypeDao = repairTypeDao;
	}




	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}



}