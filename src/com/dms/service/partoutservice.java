package com.dms.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;
import com.dms.entity.RepairType;

public interface partoutservice {
	List<RepairType> getAllRepairType();
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN);
	List<Employee> getSA();
	Order getLastOrder(String plateNumber, String VIN);
	List<Employee> getMa_Tec();
	public List<Employee> getInspectors();
	
	Order saveOrder(Order order);
	
	String getCurrentNum();   //得到当前订单编号
	void updateNum(String num); //更新当前订单编号
	void deleteOrder(String orderId);
	
	void updateOrder(Order order);
	
	public List<Order> getAllOrders();  //查询所有的在修订单
	public List<Order> getOrders(String orderId, String plateNumber, int employeeId, int repairId);      //根据条件查询在修订单
	public Order getOrderByOrderId(String orderId);
	List<Part> getOrderPartsByOrderId(String orderId);           //根据订单号获取对应的所有配件材料
	public List<Employee> getAllEmployee();          //获取所有员工
	void updatepicker(@Param("Id")Integer Id,@Param("picker")Integer picker);      //领料人变更
	void dedeletepart(@Param("Id")Integer Id);          //根据中间表Id删除单个零件
	public List<Part> getPart(Part part);	//根据配件号和配件名、车型查询材料
	void addpartonOrder(@Param("orderId")String orderId,@Param("partId")String partId,@Param("picker")int picker);//添加零件
}
