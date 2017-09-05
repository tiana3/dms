package com.dms.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;
import com.dms.entity.RepairType;

public interface partoutservice {
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
	List<Part> getOrderPartsByOrderId(String orderId);           //���ݶ����Ż�ȡ��Ӧ�������������
	public List<Employee> getAllEmployee();          //��ȡ����Ա��
	void updatepicker(@Param("Id")Integer Id,@Param("picker")Integer picker);      //�����˱��
	void dedeletepart(@Param("Id")Integer Id);          //�����м��Idɾ���������
}
