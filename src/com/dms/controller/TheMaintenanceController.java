package com.dms.controller;


import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.dao.impl.TheMaintenanceDaoImpl;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.RepairType;
import com.dms.service.TheMaintenanceService;

@Controller
public class TheMaintenanceController {

	@RequestMapping("theMaintenance.do")
	public String order(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		TheMaintenanceService  service = (TheMaintenanceService) ctx.getBean("theMaintenanceServiceImpl");
		
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		return "theMaintenance";
	}
	
	@RequestMapping("getOrders.do")
	public String getOrders(Model mode, @RequestParam(value = "plateNumber")String plateNumber, @RequestParam(value = "repairId")String repairId, @RequestParam(value = "employeeId")String employeeId) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		TheMaintenanceService  service = (TheMaintenanceService) ctx.getBean("theMaintenanceServiceImpl");
			
	
		List<Order> order = service.getOrders(plateNumber, Integer.parseInt(repairId), Integer.parseInt(employeeId));
		
		List<RepairType> repairType = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		mode.addAttribute("repairType", repairType);
		mode.addAttribute("order", order);
		mode.addAttribute("sa", sa);
		return "theMaintenance";
	}
	
}
