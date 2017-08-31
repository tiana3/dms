package com.dms.dao.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dms.dao.SettlementDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;

public class SettlementDaoImpl implements SettlementDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<Order> getSettlementByWordKey(Date completedDate, Integer SA, Integer orderStateId,
		 CustomerCarInfo customerCarInfo, Integer orderId) {
		 SettlementDao mapper = sqlSessionTemplate.getMapper(SettlementDao.class);
		 List<Order> order = mapper.getSettlementByWordKey(completedDate, SA, orderStateId, customerCarInfo, orderId);
		return order;
	}

}
