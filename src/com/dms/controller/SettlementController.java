package com.dms.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Order;
import com.dms.service.CustomerCarInfoService;
import com.dms.service.SettlementService;

@Controller
public class SettlementController {
	
	@RequestMapping("settlement.do")
	public String rider(Model model) {
		return "settlement";
	}
	@RequestMapping("settlementlist.do")
	public String getSettlementAll(Model model,@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("orderStateId")Integer orderStateId,@Param("customerCarInfo") String customerCarInfo,@Param("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService  service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Order> order = service.getSettlementByWordKey(completedDate, SA, orderStateId, customerCarInfo, orderId);
		model.addAttribute("order", order);
		return "settlement" ;
	}
}
