package com.dms.dao;

import java.util.List;

import com.dms.entity.Part;

public interface PartDao {
	//�������
	public Integer addPart(Part part);	 		//��Ӳ���
	public void delPart(Integer id); 			//ɾ������
	public void updatePart(Part part);		//�޸Ĳ���
	public List<Part> getPart(Part part);	//��������ź�����������Ͳ�ѯ����
	public Part getPartById(Integer partId);
}
