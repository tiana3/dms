package com.dms.dao.impl;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.dao.EmployeeDao;
import com.dms.dao.OrderDao;
import com.dms.entity.Custom;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;
import com.dms.entity.RepairType;


public class TheMaintenanceDaoImpl implements OrderDao{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<Order> getAllOrders() {
		OrderDao dao = (OrderDao) sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> order = dao.getAllOrders();
		return order;
	}
	
	@Override
	public List<Employee> getSA() {
		EmployeeDao dao = (EmployeeDao) sqlSessionTemplate.getMapper(EmployeeDao.class);
		List<Employee> employee = dao.getSA();
		return employee;
		
	}

	@Override
	public List<Order> getOrders(String plateNumber, int employeeId, int repairId) {
		OrderDao dao = (OrderDao) sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> order = dao.getOrders(plateNumber, repairId, employeeId);
		
		return order;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getLastOrder(String plateNumber, String VIN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustoms(String orderId, List<Custom> customs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParts(String orderId, List<Part> parts) {
		// TODO Auto-generated method stub
		
	}

}
