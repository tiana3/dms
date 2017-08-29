package com.dms.service;

import java.util.List;

import com.dms.entity.CustomerCarInfo;

public interface CustomerCarInfoService {
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN); //根据车牌或者车架号，查询获取客户车辆信息
	List<CustomerCarInfo> getCustomerCarInfoByWordKey(String plateNumber, String VIN,String customerName,String phone);//根据车牌号、车架号、客户姓名、客户电话查询车辆信息
	void addCustomerCarInfo(CustomerCarInfo info);				//增加车辆信息
	void removeCustomerCarInfo(int customerCarInfoId);			//根据车辆id 删除信息
	void updateCustomerCarInfo(CustomerCarInfo info);			//修改客户车辆信息
	CustomerCarInfo getCustomerCarInfoById(int customerCarInfoId);				//根据id 查询客户车辆信息
}
