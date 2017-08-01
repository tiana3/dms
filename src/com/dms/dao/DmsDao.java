package com.dms.dao;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.WorkHour;

public interface DmsDao {
	//�ͻ�������Ϣ����
	CustomerCarInfo getCustomerCarInfo(String key); //���ݳ��ƻ��߳��ܺţ���ѯ��ȡ�ͻ�������Ϣ
	void addCustomerCarInfo(CustomerCarInfo info);  //��ӿͻ�������Ϣ
	void removeCustomerCarInfo(int customerCarInfoId);//����idɾ����Ϣ
	void updateCustomerCarInfo(CustomerCarInfo info);//�޸Ŀͻ�������Ϣ
	
	//��ʱ��λ����
	List<WorkHour> getWorkHour(String workplaceName, int modelId); //���ݹ�λ���ͳ��Ͳ�ѯ��ȡ��λ��Ŀ
	void addWorkHour(WorkHour workhour);     //��ӹ�λ
	void removeWorkHour(int workplaceId); //���ݹ�λidɾ����λ
	void updateWorkHour(WorkHour workhour); //�޸Ĺ�λ
	
	//
	
	
}
