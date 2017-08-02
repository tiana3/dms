package com.dms.dao;

import java.util.List;

import com.dms.entity.WorkHour;

public interface WorkHourDao {
	//��ʱ��λ����
	List<WorkHour> getWorkHour(String workplaceName, int modelId); //���ݹ�λ���ͳ��Ͳ�ѯ��ȡ��λ��Ŀ
	void addWorkHour(WorkHour workhour);     //��ӹ�λ
	void removeWorkHour(int workplaceId); //���ݹ�λidɾ����λ
	void updateWorkHour(WorkHour workhour); //�޸Ĺ�λ

}
