package com.dms.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.PartOut;

public interface partoutservice {
	public ArrayList<PartOut> getrepairtype();  //��ȡά������
	public ArrayList<PartOut> getpart();         //��ȡ����
	public ArrayList<PartOut> getpartoutByJSP(String orderId,String plateNumber,String name,Integer repairTypeId);//ģ����Ѱ��ʾ������Ϣ
	public ArrayList<PartOut> getemployees();      //��ȡԱ��
	public ArrayList<PartOut> getemployeefu();     //��ȡ���з������
	public ArrayList<PartOut> getpartwithorder(@Param(value = "orderId") String orderId);   //��ȡ�����Ŷ�Ӧ�������
}
