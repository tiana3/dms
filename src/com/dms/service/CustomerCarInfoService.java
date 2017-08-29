package com.dms.service;

import java.util.List;

import com.dms.entity.CustomerCarInfo;

public interface CustomerCarInfoService {
	CustomerCarInfo getCustomerCarInfoByKey(String plateNumber, String VIN); //���ݳ��ƻ��߳��ܺţ���ѯ��ȡ�ͻ�������Ϣ
	List<CustomerCarInfo> getCustomerCarInfoByWordKey(String plateNumber, String VIN,String customerName,String phone);//���ݳ��ƺš����ܺš��ͻ��������ͻ��绰��ѯ������Ϣ
	void addCustomerCarInfo(CustomerCarInfo info);				//���ӳ�����Ϣ
	void removeCustomerCarInfo(int customerCarInfoId);			//���ݳ���id ɾ����Ϣ
	void updateCustomerCarInfo(CustomerCarInfo info);			//�޸Ŀͻ�������Ϣ
	CustomerCarInfo getCustomerCarInfoById(int customerCarInfoId);				//����id ��ѯ�ͻ�������Ϣ
}
