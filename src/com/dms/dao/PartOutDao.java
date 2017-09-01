package com.dms.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.PartOut;

public interface PartOutDao {
	public ArrayList<PartOut> getrepairtype();  //��ȡά������
	public ArrayList<PartOut> getpart();         //��ȡ����
	public ArrayList<PartOut> getpartoutByJSP(@Param(value = "orderId") String orderId,@Param(value = "plateNumber") String plateNumber,@Param(value = "name") String name,@Param(value = "repairTypeId") Integer repairTypeId);//ģ����Ѱ��ʾ������Ϣ
	public ArrayList<PartOut> getemployees();      //��ȡԱ��
	public ArrayList<PartOut> getemployeefu();     //��ȡ���з������
	public ArrayList<PartOut> getpartwithorder(@Param(value = "orderId") String orderId);   //��ȡ�����Ŷ�Ӧ�������
}
