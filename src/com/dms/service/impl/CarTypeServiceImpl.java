package com.dms.service.impl;

import java.util.List;

import com.dms.dao.CarTypeDao;
import com.dms.dao.impl.CarTypeDaoImpl;
import com.dms.entity.CarType;
import com.dms.service.CarTypeService;

public class CarTypeServiceImpl implements CarTypeService {
	CarTypeDao dao = new CarTypeDaoImpl();
	
	@Override
	public List<CarType> getAllCarType() {
		return dao.getAllCarType();
	}

	@Override
	public void addCarType(CarType carType) {
		dao.addCarType(carType);
	}

	@Override
	public void removeCarType(int CarTypeId) {
		dao.removeCarType(CarTypeId);
	}

	@Override
	public void updateCarType(CarType carType) {
		dao.updateCarType(carType);
	}

}
