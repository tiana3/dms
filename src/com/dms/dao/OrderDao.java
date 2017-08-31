package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Custom;
import com.dms.entity.Order;
import com.dms.entity.Part;

public interface OrderDao {
	//订单 的 操作
	List<Order> getAllOrders();   // 查看所有订单
	//根据客户车辆信息id号，服务顾问id号，维修类型id号   查询获取所有订单
	List<Order> getOrders(int customerCarInfoId, int employeeId, int repairId);

	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);//查询出最后一次订单的送修人和电话
	
	void addOrder(Order order);     //添加订单基本信息
	void addCustoms(@Param("orderId")String orderId, @Param("customs")List<Custom> customs);    // 存储对应订单里所有的自定义工时
	void addParts(@Param("orderId")String orderId, @Param("parts")List<Part> parts);  			// 存储对应订单里所有的材料
	
	void deleteOrder(String orderId);   //根据订单号删除维修单
	void deleteCustoms(String orderId);  //根据订单号删除所有对应的自定义维修项目
	void deleteParts(String orderId); //根据订单号删除所有对应的配件材料
}
