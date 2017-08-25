package com.dms.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.RepairType;
import com.dms.service.CustomerCarInfoService;
import com.dms.service.OrderService;

@Controller
public class OrderController {

	@RequestMapping("order.do")
	public String order(Model model) {
		return "orderIndex";
	}
	
	@RequestMapping("getCustomer.do")
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		CustomerCarInfo carInfo = service.getCustomerCarInfoByKey(plateNumber, VIN);
		List<RepairType> repairType = service.getAllRepairType();
		
		model.addAttribute("repairType", repairType);
		model.addAttribute("carInfo", carInfo);
		return "orderIndex";
	}
}
