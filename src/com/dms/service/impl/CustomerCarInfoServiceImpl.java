package com.dms.service.impl;

import java.util.List;

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
		CustomerCarInfo customerCarInfo = customerCarInfoDao.getCustomerCarInfoByKey(plateNumber, VIN); 	//���ݳ��ƺţ����ܺŲ�ѯ�ͻ�������Ϣ
		return customerCarInfo;
	}

	@Override
	public List<CustomerCarInfo> getCustomerCarInfoByWordKey(String plateNumber, String VIN, String customerName,		
			String phone) {
		List<CustomerCarInfo> customerCarInfo = customerCarInfoDao.getCustomerCarInfoByWordKey(plateNumber, VIN, customerName, phone);//���ݳ��ƺţ����ܺţ��ͻ��������绰��ѯ�ͻ�������Ϣ
		return customerCarInfo;
	}

	@Override
	public void addCustomerCarInfo(CustomerCarInfo info) {		//����û�����
		 
		customerCarInfoDao.addCustomerCarInfo(info);
	}

	@Override
	public void removeCustomerCarInfo(int customerCarInfoId) {		//ɾ���ͻ�����
		
		customerCarInfoDao.removeCustomerCarInfo(customerCarInfoId);
	}

	@Override
	public void updateCustomerCarInfo(CustomerCarInfo info) {		//�޸Ŀͻ�������Ϣ
		
		customerCarInfoDao.updateCustomerCarInfo(info);
	}

	@Override
	public CustomerCarInfo getCustomerCarInfoById(int customerCarInfoId) {		
		CustomerCarInfo customerCarInfo = customerCarInfoDao.getCustomerCarInfoById(customerCarInfoId);
		return customerCarInfo;
	}
	

}
