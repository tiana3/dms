package com.dms.service.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.dms.dao.PartOutDao;
import com.dms.entity.PartOut;
import com.dms.service.partoutservice;

public class partoutserviceDao implements partoutservice {
	private PartOutDao partoutdao;
	
	public PartOutDao getPartoutdao() {
		return partoutdao;
	}

	public void setPartoutdao(PartOutDao partoutdao) {
		this.partoutdao = partoutdao;
	}

	@Override
	public ArrayList<PartOut> getrepairtype() {
		// TODO Auto-generated method stub
		return partoutdao.getrepairtype();
	}

	@Override
	public ArrayList<PartOut> getpart() {
		// TODO Auto-generated method stub
		return partoutdao.getpart();
	}

	@Override
	public ArrayList<PartOut> getpartoutByJSP(String orderId,String plateNumber,String name,Integer repairTypeId) {
		// TODO Auto-generated method stub
		return partoutdao.getpartoutByJSP(orderId, plateNumber, name, repairTypeId);
	}

	@Override
	public ArrayList<PartOut> getemployees() {
		// TODO Auto-generated method stub
		return partoutdao.getemployees();
	}

	@Override
	public ArrayList<PartOut> getemployeefu() {
		// TODO Auto-generated method stub
		return partoutdao.getemployeefu();
	}

	@Override
	public ArrayList<PartOut> getpartwithorder(String orderId) {
		// TODO Auto-generated method stub
		return partoutdao.getpartwithorder(orderId);
	}

}
