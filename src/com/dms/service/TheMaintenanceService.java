package com.dms.service;

import java.util.List;

import com.dms.entity.Order;
import com.dms.entity.RepairType;

public interface TheMaintenanceService {
	List<Order> getAllOrders();
	List<RepairType> getAllRepairType();
}
