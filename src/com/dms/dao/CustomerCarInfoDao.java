package com.dms.dao;

import com.dms.entity.CustomerCarInfo;

	
public interface CustomerCarInfoDao {
	//客户车辆信息操作
	CustomerCarInfo getCustomerCarInfo(String key); //根据车牌或者车架号，查询获取客户车辆信息
	void addCustomerCarInfo(CustomerCarInfo info);  //添加客户车辆信息
	void removeCustomerCarInfo(int customerCarInfoId);//根据id删除信息
	void updateCustomerCarInfo(CustomerCarInfo info);//修改客户车辆信息				
}
