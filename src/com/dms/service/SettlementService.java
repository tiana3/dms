package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Employee;
import com.dms.entity.Order;

public interface SettlementService {
	
	public List<Order> getSettlementByWordKey( String completedDate,Integer SA, String plateNumber,
			 String orderId);
	public List<Employee> getSA();
	public Order getOrderById(String orderId);
	public void updateOrderById(Order order);
	public List<Order> getSettlementByOrderStateId(String settlementDate, Integer sA, String plateNumber,
			String orderId);
	void updateOrderStateId(String orderId);
	public void deleteWorkout(String orderId);
}
