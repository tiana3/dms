package com.dms.service.impl;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

public class CustomerCarInfoServiceImpl implements CustomerCarInfoService {
	private CustomerCarInfoDao customerCarInfoDao;
	
	public CustomerCarInfoDao getCustomerCarInfoDao() {
		return customerCarInfoDao;
	}

	public void setCustomerCarInfoDao(CustomerCarInfoDao customerCarInfoDao) {
		this.customerCarInfoDao = customerCarInfoDao;
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN) {
		CustomerCarInfo customerCarInfo = customerCarInfoDao.getCustomerCarInfoByKey(plateNumber, VIN);
		return customerCarInfo;
	}

}
