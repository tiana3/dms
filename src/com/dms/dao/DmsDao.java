package com.dms.dao;

import java.util.List;

import com.dms.entity.Part;

public interface DmsDao {
	
	public void addPart(Part part);	 								//��Ӳ���
	public void delPart(int id); 									//ɾ������
	public void updatePart(Part part);								//�޸Ĳ���
	public List<Part> getPart(String keyword,int modelId);			//��������ź�����������Ͳ�ѯ����
}
