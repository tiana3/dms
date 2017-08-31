package com.dms.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.dao.EmployeeDao;
import com.dms.dao.OrderDao;
import com.dms.dao.RepairTypeDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.TheMaintenanceService;

public class TheMaintenanceServiceImpl implements TheMaintenanceService {


	private OrderDao orderDao;
	private RepairTypeDao repairTypeDao;
	private EmployeeDao employeeDao;
	private CustomerCarInfoDao customerCarInfoDao;
	
	@Override
	public List<RepairType> getAllRepairType() {
		List<RepairType> repairType = repairTypeDao.getAllRepairType();
		return repairType;
	}
	
	@Override
	public List<Employee> getSA(){
		List<Employee> employee = employeeDao.getSA();
		return employee;
		
	}

	@Override
	public List<Order> getOrders(String plateNumber, int employeeId, int repairId){
		List<Order> order = orderDao.getOrders(plateNumber, repairId, employeeId);
		return order;
	}
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> order = orderDao.getAllOrders();
		return order;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public RepairTypeDao getRepairTypeDao() {
		return repairTypeDao;
	}

	public void setRepairTypeDao(RepairTypeDao repairTypeDao) {
		this.repairTypeDao = repairTypeDao;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public CustomerCarInfoDao getCustomerCarInfoDao() {
		return customerCarInfoDao;
	}

	public void setCustomerCarInfoDao(CustomerCarInfoDao customerCarInfoDao) {
		this.customerCarInfoDao = customerCarInfoDao;
	}

	
}
