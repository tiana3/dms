package com.dms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.OrderDao;
import com.dms.entity.Custom;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;

public class OrderDaoImpl implements OrderDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public Order getLastOrder(String plateNumber, String VIN) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		return mapper.getLastOrder(plateNumber, VIN);
	}

	@Override
	public List<Order> getAllOrders() {
		OrderDao maper = (OrderDao) sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> orders = maper.getAllOrders();
		return orders;
	}
	
	/**
	 * 添加新订单，保存基本信息，和所有工时和所有材料
	 */
	@Transactional
	@Override
	public void addOrder(Order order) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addOrder(order);
		
		List<Custom> customs = order.getCustoms();
		List<Part> parts = order.getParts();
		if(customs != null) {
			addCustoms(order.getOrderId(), customs);
		}
		if (parts != null) {
			addParts(order.getOrderId(), parts);
		}
	}
	
	/**
	 * 修改订单，修改基本信息，更改所有工时和所有材料
	 */
	@Transactional
	@Override
	public void updateOrder(Order order) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		deleteOrder(order.getOrderId());
		addOrder(order);
	}

	@Override
	public void addCustoms(String orderId, List<Custom> customs) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addCustoms(orderId, customs);
	}

	@Override
	public void addParts(String orderId, List<Part> parts) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addParts(orderId, parts);
	}
	
	
	@Transactional
	@Override
	public void deleteOrder(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.deleteOrder(orderId);
		deleteCustoms(orderId);
		deleteParts(orderId);
	}

	@Override
	public void deleteCustoms(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.deleteCustoms(orderId);
	}

	@Override
	public void deleteParts(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.deleteParts(orderId);		
	}

	@Override
	public List<Custom> getOrderCustomsByOrderId(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		return mapper.getOrderCustomsByOrderId(orderId);
	}

	@Override
	public List<Part> getOrderPartsByOrderId(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		return mapper.getOrderPartsByOrderId(orderId);
	}

	@Override
	public List<Employee> getSA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrders(String orderId, String plateNumber, int employeeId, int repairId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> orders = mapper.getOrders(orderId, plateNumber, repairId, employeeId);
		
		return orders;
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);		
		return mapper.getOrderByOrderId(orderId);
	}

	@Override
	public List<Order> getSettlementByWordKey(String completedDate, Integer SA,
			String plateNumber, String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> order =mapper.getSettlementByWordKey(completedDate, SA, plateNumber, orderId);
		return order;
	}
		
	public void updatepicker(Integer Id, Integer picker) {
		// TODO Auto-generated method stub
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);	
		mapper.updatepicker(Id, picker);
	}

	@Override
	public void dedeletepart(Integer Id) {
		// TODO Auto-generated method stub
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.dedeletepart(Id);
	}

	@Override
	public void addpartonOrder(String orderId, String partId, int picker) {
		// TODO Auto-generated method stub
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.addpartonOrder(orderId, partId, picker);
	}

	@Override
	public void complete(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.complete(orderId);
	}

	@Override
	public Order getOrderById(String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		Order order = mapper.getOrderById(orderId);
		return order;
	}

	@Override
	public List<Order> getSettlementByOrderStateId(String settlementDate, Integer SA, String plateNumber,
			String orderId) {
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		List<Order> order =mapper.getSettlementByOrderStateId(settlementDate, SA, plateNumber, orderId);
		return order;
	}
	@Override
	public void updateOrderStateId(String orderId) {
		
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);	
		mapper.updateOrderStateId(orderId);
	}
	@Override
	public void deleteWorkout(String orderId) {
		// TODO Auto-generated method stub
		OrderDao mapper = sqlSessionTemplate.getMapper(OrderDao.class);
		mapper.deleteWorkout(orderId);
	}


}

}
