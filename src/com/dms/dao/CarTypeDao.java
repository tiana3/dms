package com.dms.dao;

import java.util.List;

import com.dms.entity.CarType;

public interface CarTypeDao {
	//车辆型号的 操作
	List<CarType> getAllCarType();   //查询所有的车辆 厂家型号
	void addCarType(CarType carType); 	// 添加厂家型号
	void removeCarType(int CarTypeId);	// 根据车辆型号id删除车辆型号
	void updateCarType(CarType carType); // 修改车辆型号数据
	CarType getCarTypeById(int modelId);
}
