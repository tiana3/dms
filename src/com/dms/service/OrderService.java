package com.dms.service;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;

public interface OrderService {
	List<RepairType> getAllRepairType();
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN);
	List<Employee> getSA();
	Order getLastOrder(String plateNumber, String VIN);
}
