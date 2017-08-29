package com.dms.dao;

import java.util.List;

import com.dms.entity.Employee;

public interface EmployeeDao {
	//员工的操作
	List<Employee> getEmployee(Employee employee);  //根据名字，查询获取员工
	List<Employee> getAllEmployee(); 	//查询获取所有员工
	void addEmployee(Employee employee); //添加员工
	void removeEmployee(int EmployeeId);	// 根据员工id删除员工
	void updateEmployee(Employee employee); // 修改员工信息
	Employee getEmployeeById(int id);     //根据id找员工

	List<Employee> getSA();      //查询所有的服务顾问和定损员
	List<Employee> getMA_Tec();   //查询所有车间员工
	List<Employee> getInspectors();  //查询所有质检 和 车间主管
}
