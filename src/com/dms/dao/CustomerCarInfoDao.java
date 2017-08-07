package com.dms.dao;

import com.dms.entity.CustomerCarInfo;

	
public interface CustomerCarInfoDao {
	//�ͻ�������Ϣ����
	CustomerCarInfo getCustomerCarInfo(String key); //���ݳ��ƻ��߳��ܺţ���ѯ��ȡ�ͻ�������Ϣ
	void addCustomerCarInfo(CustomerCarInfo info);  //��ӿͻ�������Ϣ
	void removeCustomerCarInfo(int customerCarInfoId);//����idɾ����Ϣ
	void updateCustomerCarInfo(CustomerCarInfo info);//�޸Ŀͻ�������Ϣ				
}
