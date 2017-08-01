package com.dms.dao;

import com.dms.entity.Part;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.WorkHour;

	
public interface DmsDao {
	public void addPart(Part part);	 								//��Ӳ���
	public void delPart(int id); 									//ɾ������
	public void updatePart(Part part);								//�޸Ĳ���
	public List<Part> getPart(String keyword,int modelId);			//��������ź�����������Ͳ�ѯ����
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
	
}
