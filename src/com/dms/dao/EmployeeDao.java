package com.dms.dao;

import java.util.List;

import com.dms.entity.Employee;

public interface EmployeeDao {
	//Ա���Ĳ���
	List<Employee> getEmployee(Employee employee);  //�������֣���ѯ��ȡԱ��
	List<Employee> getAllEmployee(); 	//��ѯ��ȡ����Ա��
	void addEmployee(Employee employee); //���Ա��
	void removeEmployee(int EmployeeId);	// ����Ա��idɾ��Ա��
	void updateEmployee(Employee employee); // �޸�Ա����Ϣ
	Employee getEmployeeById(int id);     //����id��Ա��

	List<Employee> getSA();      //��ѯ���еķ�����ʺͶ���Ա
	List<Employee> getMA_Tec();   //��ѯ���г���Ա��
	List<Employee> getInspectors();  //��ѯ�����ʼ� �� ��������
}
