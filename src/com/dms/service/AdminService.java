package com.dms.service;

import com.dms.entity.AdminPowers;

public interface AdminService {
	public AdminPowers getAdmin(String user, String password);
}
