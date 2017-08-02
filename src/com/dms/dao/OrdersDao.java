package com.dms.dao;

import java.util.List;

import com.dms.entity.Orders;

public interface OrdersDao {
	//���� �� ����
	List<Orders> getAllOrders();   // �鿴���ж���
	//���ݿͻ�������Ϣid�ţ��������id�ţ�ά������id��   ��ѯ��ȡ���ж���
	List<Orders> getOrders(int customerCarInfoId, int employeeId, int repairId);
	void addOrder(Orders order);
	void updateOrder(Orders order);	

}
