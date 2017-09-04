package com.dms.service;

import java.util.List;


import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;

public interface SettlementService {
	public List<Order> getSettlementByWordKey( String completedDate,String SA,Integer orderStateId, CustomerCarInfo customerCarInfo,
			 Integer orderId);
	
	public List<Order> getSettlementAll();
}
