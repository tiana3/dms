package com.dms.controller;


import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.dao.OrdersDao;
import com.dms.dao.impl.TheMaintenanceDaoImpl;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.TheMaintenanceService;

@Controller
public class TheMaintenanceController {
	
	@RequestMapping("theMaintenance.do")
	public String order(Model model) {
		return "theMaintenance";
	}
	
	@RequestMapping("getAllOrders.do")
	public String getAllOrders(Model mode) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		TheMaintenanceService  service = (TheMaintenanceService)ctx.getBean("theMaintenanceServiceImpl");
		
		List<Order> order = service.getAllOrders();
		List<RepairType> repairType = service.getAllRepairType();
		mode.addAttribute("repairType", repairType);
		mode.addAttribute("order", order);
		return "theMaintenance";
	}

}
