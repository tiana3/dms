package com.dms.dao;

import java.util.List;

import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Orders;
import com.dms.entity.Part;
import com.dms.entity.WorkHour;

	
public interface CustomerCarInfoDao {
	//�ͻ�������Ϣ����
	CustomerCarInfo getCustomerCarInfo(String key); //���ݳ��ƻ��߳��ܺţ���ѯ��ȡ�ͻ�������Ϣ
	void addCustomerCarInfo(CustomerCarInfo info);  //��ӿͻ�������Ϣ
	void removeCustomerCarInfo(int customerCarInfoId);//����idɾ����Ϣ
	void updateCustomerCarInfo(CustomerCarInfo info);//�޸Ŀͻ�������Ϣ
	
	//��ʱ��λ����
	List<WorkHour> getWorkHour(String workplaceName, int modelId); //���ݹ�λ���ͳ��Ͳ�ѯ��ȡ��λ��Ŀ
	void addWorkHour(WorkHour workhour);     //��ӹ�λ
	void removeWorkHour(int workplaceId); //���ݹ�λidɾ����λ
	void updateWorkHour(WorkHour workhour); //�޸Ĺ�λ
	
	//�������
	public void addPart(Part part);	 								//��Ӳ���
	public void delPart(int id); 									//ɾ������
	public void updatePart(Part part);								//�޸Ĳ���
	public List<Part> getPart(String keyword,int modelId);			//��������ź�����������Ͳ�ѯ����

	//Ա���Ĳ���
	List<Employee> getEmployee(String name);
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
	void removeEmployee(int EmployeeId);
	void updateEmployee(Employee employee);
	
	//�����ͺŵ� ����
	List<CarType> getAllCarType();
	void addCarType(CarType carType);
	void removeCarType(int CarTypeId);
	void updateCarType(CarType carType);
	
	//���� �� ����
	List<Orders> getAllOrders();
	List<Orders> getOrders(String plateNumber, String employeeName, int repairId);
	void addOrder(Orders order);
	void updateOrder(Orders order);	
}
