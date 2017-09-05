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
	public List<Order> getSettlementByWordKey(String completedDate, Integer SA, Integer orderStateId,
			String customerCarInfo, String orderId) {
			List<Order> order = orderDao.getSettlementByWordKey(completedDate, SA, orderStateId, customerCarInfo, orderId);
			return order; 
	}


}
