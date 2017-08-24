package com.dms.service;

import com.dms.entity.CustomerCarInfo;

public interface CustomerCarInfoService {
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN); //根据车牌或者车架号，查询获取客户车辆信息

}
