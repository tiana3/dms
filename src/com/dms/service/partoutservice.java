package com.dms.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.PartOut;

public interface partoutservice {
	public ArrayList<PartOut> getrepairtype();  //获取维修类型
	public ArrayList<PartOut> getpart();         //获取材料
	public ArrayList<PartOut> getpartoutByJSP(String orderId,String plateNumber,String name,Integer repairTypeId);//模糊搜寻显示出库信息
	public ArrayList<PartOut> getemployees();      //获取员工
	public ArrayList<PartOut> getemployeefu();     //获取所有服务顾问
	public ArrayList<PartOut> getpartwithorder(@Param(value = "orderId") String orderId);   //获取订单号对应零件详情
}
