package com.dms.dao;

public interface OrderIdBuildDao {
	String getCurrentNum();
	void updateNum(String num);
}
