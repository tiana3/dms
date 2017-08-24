package com.dms.dao;

import java.util.List;

import com.dms.entity.WorkHour;

public interface WorkHourDao {
	//��ʱ��λ����
	List<WorkHour> getWorkHour();	//��ѯ���й�ʱ��λ
	List<WorkHour> getWorkHour(String workplaceName); //���ݹ�λ����ѯ��ȡ��λ��Ŀ
	Integer addWorkHour(WorkHour workhour);     //��ӹ�λ
	void removeWorkHour(int workplaceId); //���ݹ�λidɾ����λ
	void updateWorkHour(WorkHour workhour); //�޸Ĺ�λ
	WorkHour getWorkHourById(int workplaceId);
}
