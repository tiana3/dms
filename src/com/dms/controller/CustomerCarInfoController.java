package com.dms.controller;


import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

@Controller
public class CustomerCarInfoController {
	
	@RequestMapping("carinfo.do")
	public String order(Model model) {
		return "customerCarInfo";
	}
	
	@RequestMapping("customerCarInfo.do")			//��ѯ�ͻ�������Ϣ										
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN
			,@RequestParam(value = "customerName") String customerName,@RequestParam(value = "phone") String phone) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		List<CustomerCarInfo> carInfo = service.getCustomerCarInfoByWordKey(plateNumber, VIN,customerName,phone);
		model.addAttribute("carInfo", carInfo);
		return "customerCarInfo";
	}
	@RequestMapping("carinfodel.do")			//ɾ���ͻ�������Ϣ									
	public String removeCustomerCarInfo(int customerCarInfoId){
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		service.removeCustomerCarInfo(customerCarInfoId);
		return "customerCarInfo";
	}
	
	@RequestMapping("getcarinfo")				//����id��ѯһ���û�
	public String getCustomerInfoById(int customerCarInfoId,HttpServletRequest request,Model model){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		List<CarType> car = service.getCarType();
		model.addAttribute("car", car);
		CustomerCarInfo carType = service.getCustomerCarInfoById(customerCarInfoId);
		model.addAttribute("carType", carType);
		return "carinfobyid";		
	}
	@RequestMapping("carinfobyid.do")			//�޸��û�
	public void updateCustomerInfoById(CustomerCarInfo info ){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");			
		service.updateCustomerCarInfo(info);
	}
	@RequestMapping("carinfoadd.do")
	public String add(Model model){	
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService  service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");			
		List<CarType> car = service.getCarType();
		model.addAttribute("car", car);
		return "carinfo_add";	
	}
	@RequestMapping("carinfo_add.do")												
	public void addCustomerCarInfo(CustomerCarInfo info,Model model){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");			
		service.addCustomerCarInfo(info);	
	}
	
}
