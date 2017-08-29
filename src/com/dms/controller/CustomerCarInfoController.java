package com.dms.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

@Controller
public class CustomerCarInfoController {
	
	@RequestMapping("carinfo.do")
	public String order(Model model) {
		return "customerCarInfo";
	}
	
	@RequestMapping("customerCarInfo.do")			//查询客户车辆信息										
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN
			,@RequestParam(value = "customerName") String customerName,@RequestParam(value = "phone") String phone) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		List<CustomerCarInfo> carInfo = service.getCustomerCarInfoByWordKey(plateNumber, VIN,customerName,phone);
		model.addAttribute("carInfo", carInfo);
		return "customerCarInfo";
	}
	@RequestMapping("carinfodel.do")			//删除客户车辆信息									
	public String removeCustomerCarInfo(int customerCarInfoId){
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		service.removeCustomerCarInfo(customerCarInfoId);
		return "customerCarInfo";
	}
	
	@RequestMapping("getcarinfo")
	public String getCustomerInfoById(int customerCarInfoId,HttpServletRequest request,Model model){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		CustomerCarInfo carType = service.getCustomerCarInfoById(customerCarInfoId);
		model.addAttribute("carType", carType);
		return "carinfobyid";		
	}
	@RequestMapping("carinfobyid.do")
	public String updateCustomerInfoById(CustomerCarInfo info ){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");	
		
		service.updateCustomerCarInfo(info);
		System.out.println(1);
		return "carinfobyid";		
	}
	
}
