package com.dms.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.service.SettlementService;

@Controller
public class SettlementController {
	
	@RequestMapping("settlement.do")
	public String rider(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		return "settlement";
	}
	@RequestMapping("settlementlist.do")
	public String getSettlementAll(Model model,@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("plateNumber") String customerCarInfo,@Param("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		List<Order> order = service.getSettlementByWordKey(completedDate, SA, customerCarInfo, orderId);
		model.addAttribute("order", order);
		return "settlement" ;
	}
	@RequestMapping("getorderbyid.do")
	public String getOrderById(Model model,String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		Order order = service.getOrderById(orderId);
		model.addAttribute("order", order);
		return "settlement-update";
	}
<<<<<<< HEAD
	@RequestMapping("workout-list.do")
	public String getSettlementall(Model model,@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("plateNumber") String customerCarInfo,@Param("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		List<Order> order = service.getSettlementByWordKey(completedDate, SA, customerCarInfo, orderId);
		model.addAttribute("order", order);
		return "workout-delete" ;
	}
	@RequestMapping("workout-delete.do")
	public void deleteworkout(Model model,@RequestParam("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		service.deleteWorkout(orderId);
=======
	@RequestMapping("updateorderbyid.do")
	public String getUpdateOrder(Model model){
		
		return null;
>>>>>>> branch 'master' of file:///\\172.13.17.209\git
	}
}
