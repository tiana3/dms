package com.dms.service;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;

public interface OrderService {
	List<RepairType> getAllRepairType();
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN);
	List<Employee> getSA();
	Order getLastOrder(String plateNumber, String VIN);
	List<Employee> getMa_Tec();
	public List<Employee> getInspectors();
	
	Order saveOrder(Order order);
	
	String getCurrentNum();   //得到当前订单编号
	void updateNum(String num); //更新当前订单编号
	void deleteOrder(String orderId);
	
	void updateOrder(Order order);
	
}
