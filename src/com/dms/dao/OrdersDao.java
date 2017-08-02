package com.dms.dao;

import java.util.List;

import com.dms.entity.Orders;

public interface OrdersDao {
	//订单 的 操作
	List<Orders> getAllOrders();   // 查看所有订单
	//根据客户车辆信息id号，服务顾问id号，维修类型id号   查询获取所有订单
	List<Orders> getOrders(int customerCarInfoId, int employeeId, int repairId);
	void addOrder(Orders order);
	void updateOrder(Orders order);	

}
