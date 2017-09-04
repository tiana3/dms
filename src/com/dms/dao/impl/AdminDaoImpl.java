package com.dms.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.AdminDao;
import com.dms.entity.AdminPowers;

public class AdminDaoImpl implements AdminDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
	@Override
	public AdminPowers getAdmin(String user, String password) {
		AdminDao mapper = sqlSessionTemplate.getMapper(AdminDao.class);
		AdminPowers adminPowers = mapper.getAdmin(user, password);
		return adminPowers;
	}

	@Override
	public void changePassword(Integer adminId, String newPassword) {
		AdminDao mapper = sqlSessionTemplate.getMapper(AdminDao.class);
		mapper.changePassword(adminId, newPassword);
	}

}
