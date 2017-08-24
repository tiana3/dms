package com.dms.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

@Controller
public class OrderController {

	@RequestMapping("order.do")
	public String order(Model model) {
		return "orderIndex";
	}
	
	@RequestMapping("getCustomer.do")
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		CustomerCarInfo carInfo = service.getCustomerCarInfoByKey(plateNumber, VIN);
		model.addAttribute("carInfo", carInfo);
		return "orderIndex";
	}
}
