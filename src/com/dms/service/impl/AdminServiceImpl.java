package com.dms.service.impl;

import com.dms.dao.AdminDao;
import com.dms.entity.AdminPowers;
import com.dms.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public AdminPowers getAdmin(String user, String password) {
		
		return adminDao.getAdmin(user, password);
	}

	@Override
	public void changePassword(Integer adminId, String newPassword) {
		adminDao.changePassword(adminId, newPassword);
	}

}
