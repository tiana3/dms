package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Custom;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;

public interface OrderDao {
	//���� �� ����
	List<Order> getAllOrders();   // �鿴���ж���
	//���ݿͻ�������Ϣid�ţ��������id�ţ�ά������id��   ��ѯ��ȡ���ж���
	List<Order> getOrders(@Param("plateNumber")String plateNumber, @Param("employeeId")int employeeId, @Param("repairId")int repairId);
	void addOrder(Order order);     //��Ӷ���������Ϣ
	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);//��ѯ�����һ�ζ����������˺͵绰
	
	void addCustoms(@Param("orderId")String orderId, @Param("customs")List<Custom> customs);    // �洢��Ӧ���������е��Զ��幤ʱ
	void addParts(@Param("orderId")String orderId, @Param("parts")List<Part> parts);  			// �洢��Ӧ���������еĲ���
	List<Employee> getSA();

}
