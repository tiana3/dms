package com.dms.service.impl;

import java.util.Date;
import java.util.List;

import com.dms.dao.SettlementDao;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;
import com.dms.service.SettlementService;

public class SettlementServiceImpl implements  SettlementService{
	
	private SettlementDao settlementdao ;
	
	public SettlementDao getSettlementDao(){
		return settlementdao ;
	}
	public void setSettlementDao(SettlementDao settlementdao){
		this.settlementdao = settlementdao;
	}
	
	@Override
	public List<Order> getSettlementByWordKey(Date completedDate, Integer SA, Integer orderStateId,
			CustomerCarInfo customerCarInfo, Integer orderId) {
		List<Order> order = settlementdao.getSettlementByWordKey(completedDate, SA, orderStateId, customerCarInfo, orderId);
		return order;
	}

}
