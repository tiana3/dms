package com.dms.service.impl;

import java.util.Date;
import java.util.List;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.dao.EmployeeDao;
import com.dms.dao.OrderDao;
import com.dms.dao.RepairTypeDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private CustomerCarInfoDao customerCarInfoDao;
	private RepairTypeDao repairTypeDao;
	private EmployeeDao employeeDao;
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public RepairTypeDao getRepairTypeDao() {
		return repairTypeDao;
	}

	public void setRepairTypeDao(RepairTypeDao repairTypeDao) {
		this.repairTypeDao = repairTypeDao;
	}

	public CustomerCarInfoDao getCustomerCarInfoDao() {
		return customerCarInfoDao;
	}

	public void setCustomerCarInfoDao(CustomerCarInfoDao customerCarInfoDao) {
		this.customerCarInfoDao = customerCarInfoDao;
	}
	
	
	
	@Override
	public List<RepairType> getAllRepairType() {
		// TODO Auto-generated method stub
		return repairTypeDao.getAllRepairType();
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN) {
		// TODO Auto-generated method stub
		return customerCarInfoDao.getCustomerCarInfoByKey(plateNumber, VIN);
	}

	@Override
	public List<Employee> getSA() {
		return employeeDao.getSA();
	}

	@Override
	public Order getLastOrder(String plateNumber, String VIN) {
		// TODO Auto-generated method stub
		return orderDao.getLastOrder(plateNumber, VIN);
	}

	@Override
	public List<Employee> getMa_Tec() {
		// TODO Auto-generated method stub
		return employeeDao.getMA_Tec();
	}

	@Override
	public List<Employee> getInspectors() {
		// TODO Auto-generated method stub
		return employeeDao.getInspectors();
	}

	@Override
	public Order saveOrder(Order order) {
		String date = new Date().toLocaleString();
		order.setDate(date);
		
		
		return null;
	}

}
