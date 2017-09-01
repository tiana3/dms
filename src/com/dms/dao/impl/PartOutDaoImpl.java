package com.dms.dao.impl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.PartOutDao;
import com.dms.entity.PartOut;

public class PartOutDaoImpl implements PartOutDao {
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public ArrayList<PartOut> getrepairtype() {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getrepairtype();
		return list;
	}

	@Override
	public ArrayList<PartOut> getpart() {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getpart();
		return list;
	}

	@Override
	public ArrayList<PartOut> getpartoutByJSP(String orderId,String plateNumber,String name,Integer repairTypeId) {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getpartoutByJSP(orderId, plateNumber, name, repairTypeId);
		return list;
	}

	@Override
	public ArrayList<PartOut> getemployees() {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getemployees();
		return list;
	}

	@Override
	public ArrayList<PartOut> getemployeefu() {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getemployeefu();
		return list;
	}

	@Override
	public ArrayList<PartOut> getpartwithorder(String orderId) {
		// TODO Auto-generated method stub
		PartOutDao mapper = sqlSessionTemplate.getMapper(PartOutDao.class);
		ArrayList<PartOut>list = mapper.getpartwithorder(orderId);
		return list;
	}

}
