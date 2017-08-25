package com.dms.service.impl;

import java.util.List;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.dao.RepairTypeDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.RepairType;
import com.dms.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private CustomerCarInfoDao customerCarInfoDao;
	private RepairTypeDao repairTypeDao;
	
	
	public RepairTypeDao getRepairTypeDao() {
		return repairTypeDao;
	}

	public void setRepairTypeDao(RepairTypeDao repairTypeDao) {
		this.repairTypeDao = repairTypeDao;
	}

	public CustomerCarInfoDao getCustomerCarInfoDao() {
		return customerCarInfoDao;
	}

	public void setCustomerCarInfoDao(CustomerCarInfoDao customerCarInfoDao) {
		this.customerCarInfoDao = customerCarInfoDao;
	}
	
	
	
	@Override
	public List<RepairType> getAllRepairType() {
		// TODO Auto-generated method stub
		return repairTypeDao.getAllRepairType();
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN) {
		// TODO Auto-generated method stub
		return customerCarInfoDao.getCustomerCarInfoByKey(plateNumber, VIN);
	}

}
