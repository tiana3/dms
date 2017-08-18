package com.dms.dao;

import java.util.List;

import com.dms.entity.CarType;

public interface CarTypeDao {
	//�����ͺŵ� ����
	List<CarType> getAllCarType();   //��ѯ���еĳ��� �����ͺ�
	void addCarType(CarType carType); 	// ��ӳ����ͺ�
	void removeCarType(int CarTypeId);	// ���ݳ����ͺ�idɾ�������ͺ�
	void updateCarType(CarType carType); // �޸ĳ����ͺ�����
	CarType getCarTypeById(int modelId);
}
