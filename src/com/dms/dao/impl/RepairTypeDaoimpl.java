package com.dms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.RepairTypeDao;
import com.dms.entity.RepairType;

public class RepairTypeDaoimpl implements RepairTypeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public List<RepairType> getAllRepairType() {
		RepairTypeDao mapper = sqlSessionTemplate.getMapper(RepairTypeDao.class);
		List<RepairType> repairType = mapper.getAllRepairType();
		
		return repairType;
	}

	public static void main (String[] args) {
		RepairTypeDaoimpl imp = new RepairTypeDaoimpl();
		imp.getAllRepairType();
	}
}
