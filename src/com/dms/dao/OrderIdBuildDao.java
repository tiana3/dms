package com.dms.dao;

public interface OrderIdBuildDao {
	Integer getCurrentNum();
	void updateNum(Integer num);
}
