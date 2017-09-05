package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Employee;
import com.dms.entity.Order;

public interface SettlementService {
	
	public List<Order> getSettlementByWordKey( String completedDate,Integer SA, String customerCarInfo,
			 String orderId);
	public List<Employee> getSA();

}
