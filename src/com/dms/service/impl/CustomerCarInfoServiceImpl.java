package com.dms.service.impl;

import java.util.List;

import com.dms.dao.CarTypeDao;
import com.dms.dao.CustomerCarInfoDao;
import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

public class CustomerCarInfoServiceImpl implements CustomerCarInfoService {
	private CustomerCarInfoDao customerCarInfoDao;
	private CarTypeDao carTypeDao;
	
	
	public CarTypeDao getCarTypeDao() {
		return carTypeDao;
	}

	public void setCarTypeDao(CarTypeDao carTypeDao) {
		this.carTypeDao = carTypeDao;
	}

	public CustomerCarInfoDao getCustomerCarInfoDao() {
		return customerCarInfoDao;
	}

	public void setCustomerCarInfoDao(CustomerCarInfoDao customerCarInfoDao) {
		this.customerCarInfoDao = customerCarInfoDao;
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN) {
		CustomerCarInfo customerCarInfo = customerCarInfoDao.getCustomerCarInfoByKey(plateNumber, VIN); 	//根据车牌号，车架号查询客户车辆信息
		return customerCarInfo;
	}

	@Override
	public List<CustomerCarInfo> getCustomerCarInfoByWordKey(String plateNumber, String VIN, String customerName,		
			String phone) {
		List<CustomerCarInfo> customerCarInfo = customerCarInfoDao.getCustomerCarInfoByWordKey(plateNumber, VIN, customerName, phone);//根据车牌号，车架号，客户姓名，电话查询客户车辆信息
		return customerCarInfo;
	}

	@Override
	public void addCustomerCarInfo(CustomerCarInfo info) {		//添加用户车辆
		 
		customerCarInfoDao.addCustomerCarInfo(info);
	}

	@Override
	public void removeCustomerCarInfo(int customerCarInfoId) {		//删除客户车辆
		
		customerCarInfoDao.removeCustomerCarInfo(customerCarInfoId);
	}

	@Override
	public void updateCustomerCarInfo(CustomerCarInfo info) {		//修改客户车辆信息
		
		customerCarInfoDao.updateCustomerCarInfo(info);
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoById(int customerCarInfoId) {		
		CustomerCarInfo customerCarInfo = customerCarInfoDao.getCustomerCarInfoById(customerCarInfoId);
		return customerCarInfo;
	}

	@Override
	public List<CarType> getCarType() {
		// TODO Auto-generated method stub
		return carTypeDao.getAllCarType();
	}


}
