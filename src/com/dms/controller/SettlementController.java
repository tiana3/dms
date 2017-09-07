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
	public String getSettlementAll(Model model,@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		List<Order> order = service.getSettlementByWordKey(completedDate, SA, plateNumber, orderId);
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
	
	@RequestMapping("cancelSettlements.do")
	public String cancelSettlements(Model model,@Param("settlementDate")String settlementDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		List<Order> order = service.getSettlementByOrderStateId(settlementDate, SA, plateNumber, orderId);
		model.addAttribute("order", order);
		return "orderSettled";
	}
	
	@RequestMapping("cancelSettlement.do")
	public String cancelSettlement(Model model,@Param("settlementDate")String settlementDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		List<Order> order = service.getSettlementByOrderStateId(null, 0, null, null);
		model.addAttribute("order", order);
		return "orderSettled";
	}
	
	@RequestMapping("updateOSId.do")
	public String updateOSId(Model model,@Param("orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		service.updateOrderStateId(orderId);
		
		return "redirect:/cancelSettlement.do";
	}
	
	@RequestMapping("workout-list.do")
	public String getentall(Model model){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		List<Order> order = service.getSettlementByWordKey(null, 0, null, null);
		model.addAttribute("order", order);
		return "workout-delete" ;
	}
	@RequestMapping("workout-li.do")
	public String getSettlementall(Model model,@Param("completedDate")String completedDate,@Param("SA")Integer SA,@Param("plateNumber") String plateNumber,@Param("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		List<Employee> employee = service.getSA();
		model.addAttribute("employee", employee);
		
		List<Order> order = service.getSettlementByWordKey(completedDate, SA, plateNumber, orderId);
		model.addAttribute("order", order);
		return "workout-delete" ;
	}
	@RequestMapping("workout-delete.do")
	public String deleteworkout(Model model,@RequestParam("orderId")String orderId){
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service = (SettlementService)ctx.getBean("settlementServiceImpl");
		service.deleteWorkout(orderId);
		return "redirect:/workout-list.do";
	}
	@RequestMapping("updateorder.do")
	public String getUpdateOrder(Model model,Order order){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SettlementService service =(SettlementService)ctx.getBean("settlementServiceImpl");
		order.setSettlementDate(new Date());
		service.updateOrderById(order);
		return "redirect:/settlement.do";
	}
	@RequestMapping("updateorderbyid.do")
	public String getUpdateOrder(Model model){
		
		return null;

	}
}
