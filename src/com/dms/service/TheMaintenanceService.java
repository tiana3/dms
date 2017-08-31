package com.dms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;

public interface TheMaintenanceService {
	List<Order> getAllOrders();
	List<RepairType> getAllRepairType();
	List<Employee> getSA();
	List<Order> getOrders(String plateNumber, int employeeId, int repairId);
}
