package com.dms.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.Custom;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;

public interface OrderDao {
	//订单 的 操作
	List<Order> getAllOrders();   // 查看所有订单
	//根据客户车辆信息id号，服务顾问id号，维修类型id号   查询获取所有订单
	List<Order> getOrders(@Param("orderId")String orderId, @Param("plateNumber")String plateNumber, @Param("employeeId")int employeeId, @Param("repairId")int repairId);
	List<Order> getSettlementByWordKey(@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId);
	List<Order> getSettlementByOrderStateId(@Param("settlementDate")String settlementDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId);

	void updateOrderStateId(@Param("orderId")String orderId);
	void updateOrder(Order order);	

	Order getLastOrder(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN);//查询出最后一次订单的送修人和电话
	
	void addOrder(Order order);     //添加订单基本信息	
	void addCustoms(@Param("orderId")String orderId, @Param("customs")List<Custom> customs);    // 存储对应订单里所有的自定义工时
	void addParts(@Param("orderId")String orderId, @Param("parts")List<Part> parts);  			// 存储对应订单里所有的材料
	List<Employee> getSA();

	void deleteOrder(String orderId);   //根据订单号删除维修单
	void deleteCustoms(String orderId);  //根据订单号删除所有对应的自定义维修项目
	void deleteParts(String orderId); //根据订单号删除所有对应的配件材料
	
	List<Custom> getOrderCustomsByOrderId(String orderId);       //根据订单号获取对应的所有自定义维修项目
	List<Part> getOrderPartsByOrderId(String orderId);           //根据订单号获取对应的所有配件材料

	Order getOrderByOrderId(String orderId);             //根据维修单号查询 维修单
	Order getOrderById(String orderId);						//根据orderId查询完修单
	void updatepicker(@Param("Id")Integer Id,@Param("picker")Integer picker);      //领料人变更
	void dedeletepart(@Param("Id")Integer Id);          //根据中间表Id删除单个零件
	void addpartonOrder(@Param("orderId")String orderId,@Param("partId")String partId,@Param("picker")int picker);
	void deleteWorkout(@Param("orderId")String orderId);     //取消完工
	void updateOrderById(Order order);
	void complete(@Param("orderId")String orderId, @Param("date")Date date);
}
