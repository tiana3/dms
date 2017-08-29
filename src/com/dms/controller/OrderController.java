package com.dms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.dao.impl.PartDaoImpl;
import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;
import com.dms.entity.RepairType;
import com.dms.service.CarTypeService;
import com.dms.service.OrderService;
import com.dms.service.impl.CarTypeServiceImpl;

@Controller
public class OrderController {

	@RequestMapping("order.do")
	public String order(Model model) {
		return "orderIndex";
	}
	
	@RequestMapping("partList.do")
	public String partList(Model model, @RequestParam(value = "partname") String partname, @RequestParam(value = "partno") String partno, @RequestParam(value = "modelid") String modelid) {
		Integer modelId = 0;
		if(modelid!=null) {
			modelId= Integer.parseInt(modelid);
		}
		Part part = new Part();
		part.setPartNo(partno);
		part.setModelId(modelId);
		part.setPartName(partname);
		
		PartDaoImpl imp = new PartDaoImpl();	
		List<Part> list = imp.getPart(part);
		model.addAttribute("partlist",list);
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		model.addAttribute("carTypes", carTypeList);
		
		return "orderSelectPart";
	}
	
	@RequestMapping("addPart.do")
	public String addpart(Model model) {
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		model.addAttribute("carTypes", carTypeList);
		
		return "orderSelectPart";
	}
	
	@RequestMapping("allWorkSelect.do")
	public String allWorkSelect(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		List<Employee> Ma_Tec = service.getMa_Tec();
		model.addAttribute("Ma_Tec", Ma_Tec);
		
		return "orderWork";
	}
	
	@RequestMapping("orderInfo.do")
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		CustomerCarInfo carInfo = service.getCustomerCarInfoByKey(plateNumber, VIN);
		List<RepairType> repairType = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		Order lastOrder = service.getLastOrder(plateNumber, VIN);
		List<Employee> Ma_Tec = service.getMa_Tec();
		List<Employee> inspectors = service.getInspectors();
		
		
		model.addAttribute("repairType", repairType);
		model.addAttribute("carInfo", carInfo);
		model.addAttribute("sa", sa);
		model.addAttribute("lastOrder", lastOrder);
		model.addAttribute("Ma_Tec", Ma_Tec);
		model.addAttribute("inspectors", inspectors);
							
		return "orderIndex";
	}
	
	
	@RequestMapping("orderSave.do")
	public String orderSave(Model model, Order order) {
		String date = new Date().toLocaleString();
		order.setDate(date);
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		
		
		
		return "orderIndex";
	}
}
