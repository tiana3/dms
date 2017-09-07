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


	public List<Order> getSettlementByOrderStateId(String settlementDate,Integer SA, String plateNumber,
			 String orderId);

	public void updateOrderStateId(String orderId);

	void deleteWorkout(@Param("orderId")String orderId);     //取消完工

}
