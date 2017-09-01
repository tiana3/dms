package com.dms.service.impl;

import java.util.List;

import com.dms.dao.OrderDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;
import com.dms.service.SettlementService;

public class SettlementServiceImpl implements SettlementService {
	
	private OrderDao orderDao ;
		
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> getSettlementByWordKey(String completedDate, String SA, Integer orderStateId,
			CustomerCarInfo customerCarInfo, Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getSettlementAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
