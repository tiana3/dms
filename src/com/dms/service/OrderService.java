package com.dms.service;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.RepairType;

public interface OrderService {
	List<RepairType> getAllRepairType();
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN);
}
