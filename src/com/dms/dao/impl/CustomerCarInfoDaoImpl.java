package com.dms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.CustomerCarInfoDao;
import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;

public class CustomerCarInfoDaoImpl implements CustomerCarInfoDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		CustomerCarInfo customerCarInfo = mapper.getCustomerCarInfoByKey(plateNumber, VIN);
		return customerCarInfo;
	}
	@Override
	public void addCustomerCarInfo(CustomerCarInfo info){
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		mapper.addCustomerCarInfo(info);
	}

	@Override
	public void removeCustomerCarInfo(int customerCarInfoId) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		mapper.removeCustomerCarInfo(customerCarInfoId);
	}

	@Override
	public void updateCustomerCarInfo(CustomerCarInfo info) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		mapper.updateCustomerCarInfo(info);		
	}
	
		@Override
	public CarType getCarTypeByModelId(int modleId) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		return mapper.getCarTypeByModelId(modleId);
	}

	@Override
	public List<CustomerCarInfo> getCustomerCarInfoByWordKey(String plateNumber, String VIN, String customerName,
			String phone) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		List<CustomerCarInfo> customerCarInfo = mapper.getCustomerCarInfoByWordKey(plateNumber, VIN,customerName,phone);
		return customerCarInfo ;
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoById(int customerCarInfoIdid) {
		CustomerCarInfoDao mapper = sqlSessionTemplate.getMapper(CustomerCarInfoDao.class);
		CustomerCarInfo customerCarInfo = mapper.getCustomerCarInfoById(customerCarInfoIdid);
		return customerCarInfo;
	}

}
