package com.dms.dao;

import java.util.List;

import com.dms.entity.Employee;

public interface EmployeeDao {
	//Ա���Ĳ���
	List<Employee> getEmployee(String name);  //�������֣���ѯ��ȡԱ��
	List<Employee> getAllEmployee(); 	//��ѯ��ȡ����Ա��
	void addEmployee(Employee employee); //���Ա��
	void removeEmployee(int EmployeeId);	// ����Ա��idɾ��Ա��
	void updateEmployee(Employee employee); // �޸�Ա����Ϣ
}
