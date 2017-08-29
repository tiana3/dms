
package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;

	
public interface CustomerCarInfoDao {
	//客户车辆信息操作

    CustomerCarInfo getCustomerCarInfoByKey(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN); //根据车牌或者车架号，查询获取客户车辆信息
	void addCustomerCarInfo(CustomerCarInfo info);  //添加客户车辆信息
	void removeCustomerCarInfo(int customerCarInfoId);//根据id删除信息
	void updateCustomerCarInfo(CustomerCarInfo info);//修改客户车辆信息				
	List<CustomerCarInfo> getCustomerCarInfoByWordKey(@Param("plateNumber")String plateNumber,@Param("VIN")String VIN,@Param("customerName")String customerName,@Param("phone")String phone);
	CustomerCarInfo getCustomerCarInfoById(int customerCarInfoIdid );  //根据id 查询数据             
}
