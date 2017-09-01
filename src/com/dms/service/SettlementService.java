package com.dms.service;

import java.util.Date;
import java.util.List;


import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;

public interface SettlementService {
	public List<Order> getSettlementByWordKey( Date completedDate,Integer SA,Integer orderStateId, CustomerCarInfo customerCarInfo,
			 Integer orderId);
}
