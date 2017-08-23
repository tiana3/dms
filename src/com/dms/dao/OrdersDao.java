package com.dms.dao;

import java.util.List;

import com.dms.entity.Order;

public interface OrdersDao {
	//���� �� ����
	List<Order> getAllOrders();   // �鿴���ж���
	//���ݿͻ�������Ϣid�ţ��������id�ţ�ά������id��   ��ѯ��ȡ���ж���
	List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId);
	void addOrder(Order order);
	void updateOrder(Order order);	

}
