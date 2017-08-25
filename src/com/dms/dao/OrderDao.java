package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Order;

public interface OrderDao {
	//���� �� ����
	List<Order> getAllOrders();   // �鿴���ж���
	//���ݿͻ�������Ϣid�ţ��������id�ţ�ά������id��   ��ѯ��ȡ���ж���
	List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId);
	void addOrder(Order order);
	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);
}
