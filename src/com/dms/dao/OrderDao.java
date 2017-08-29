package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Order;

public interface OrderDao {
	//订单 的 操作
	List<Order> getAllOrders();   // 查看所有订单
	//根据客户车辆信息id号，服务顾问id号，维修类型id号   查询获取所有订单
	List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId);
	void addOrder(Order order);
	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);
}
