package com.dms.dao;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.AdminPowers;

public interface AdminDao {
	AdminPowers getAdmin(@Param("user")String user, @Param("password")String password);
	void changePassword(@Param("adminId")Integer adminId,@Param("newPassword")String newPassword);
}
