package com.dms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.dao.EmployeeDao;
import com.dms.dao.OrderDao;
import com.dms.dao.OrderIdBuildDao;
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
	private OrderIdBuildDao orderIdBuildDao;
	
	public OrderIdBuildDao getOrderIdBuildDao() {
		return orderIdBuildDao;
	}

	public void setOrderIdBuildDao(OrderIdBuildDao orderIdBuildDao) {
		this.orderIdBuildDao = orderIdBuildDao;
	}

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
	@Transactional
	@Override
	public Order saveOrder(Order order) {
		//设置当前时间保存到数据库     开单时间
		String date = new Date().toLocaleString();
		order.setDate(date);
		//生成订单号
		String currentNum = orderIdBuildDao.getCurrentNum();
		String subCurrentNum = currentNum.substring(0, 8);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentDay = format.format(new Date());
		
		if(subCurrentNum.equals(currentDay)) {
			Long parseCurrentNum = Long.parseLong(currentNum);
			String updateNum = Long.toString(parseCurrentNum+1);
			orderIdBuildDao.updateNum(updateNum);
			order.setOrderId(updateNum);
		}else {
			String newNum = currentDay + "001";
			orderIdBuildDao.updateNum(newNum);
			order.setOrderId(newNum);
		}
		orderDao.addOrder(order);
		
		return order;
	}

	@Override
	public String getCurrentNum() {
		return orderIdBuildDao.getCurrentNum();
	}

	@Override
	public void updateNum(String num) {
		orderIdBuildDao.updateNum(num);
	}

	@Override
	public void deleteOrder(String orderId) {
		orderDao.deleteOrder(orderId);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public List<Order> getOrders(String orderId, String plateNumber, int employeeId, int repairId) {
		
		return orderDao.getOrders(orderId, plateNumber, employeeId, repairId);
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByOrderId(orderId);
	}

}
