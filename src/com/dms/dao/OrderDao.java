package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Custom;
import com.dms.entity.Order;
import com.dms.entity.Part;

public interface OrderDao {
	//���� �� ����
	List<Order> getAllOrders();   // �鿴���ж���
	//���ݿͻ�������Ϣid�ţ��������id�ţ�ά������id��   ��ѯ��ȡ���ж���
	List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId);

	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);//��ѯ�����һ�ζ����������˺͵绰
	
	void addOrder(Order order);     //��Ӷ���������Ϣ
	void addCustoms(@Param("orderId")String orderId, @Param("customs")List<Custom> customs);    // �洢��Ӧ���������е��Զ��幤ʱ
	void addParts(@Param("orderId")String orderId, @Param("parts")List<Part> parts);  			// �洢��Ӧ���������еĲ���
	
	void deleteOrder(String orderId);   //���ݶ�����ɾ��ά�޵�
	void deleteCustoms(String orderId);  //���ݶ�����ɾ�����ж�Ӧ���Զ���ά����Ŀ
	void deleteParts(String orderId); //���ݶ�����ɾ�����ж�Ӧ���������
}
