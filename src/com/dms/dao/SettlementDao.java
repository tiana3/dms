package com.dms.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;

public interface SettlementDao {
		public List<Order> getSettlementByWordKey(@Param("completedDate") Date completedDate,@Param("SA") Integer SA,
				@Param("orderStateId") Integer orderStateId, @Param("customerCarInfo") CustomerCarInfo customerCarInfo,
				@Param("orderId") Integer orderId);
}
