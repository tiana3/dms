package com.dms.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	String getCurrentNum();   //�õ���ǰ�������
	void updateNum(String num); //���µ�ǰ�������
	void deleteOrder(String orderId);
	
	void updateOrder(Order order);
	
	public List<Order> getAllOrders();  //��ѯ���е����޶���
	public List<Order> getOrders(String orderId, String plateNumber, int employeeId, int repairId);      //����������ѯ���޶���
	public Order getOrderByOrderId(String orderId);
	void complete(String orderId, Date date);
}
