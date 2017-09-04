package com.dms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.Employee;
import com.dms.entity.Order;
import com.dms.entity.Part;
import com.dms.entity.RepairType;
import com.dms.service.partoutservice;

@Controller
public class PartOutListController {

	
	@RequestMapping("partout.do")
	public String order(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		List<Order> allOrders = service.getAllOrders();
		
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		
		return "part-out";
	}

	
	
	@RequestMapping("partoutlist.do")
	public String getOrders(Model model, @RequestParam(value = "orderId")String orderId, @RequestParam(value = "plateNumber")String plateNumber, @RequestParam(value = "employeeId")int employeeId, @RequestParam(value = "repairId")int repairId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		List<Order> allOrders = service.getOrders(orderId, plateNumber, employeeId, repairId);
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		return "part-out";
	
	}
	@RequestMapping("showOrderandpart.do")
	public String getOrderandpart(Model model, @RequestParam(value = "orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		System.out.println(orderId);
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		List<Order> allOrders = service.getOrders(orderId, null, 0, 0);
		List<Part>parts = service.getOrderPartsByOrderId(orderId);
		List<Employee>employees = service.getAllEmployee();
		List<Employee>employees2 = service.getMa_Tec();
		System.out.println(parts.toString());
		model.addAttribute("employees",employees);
		System.out.println(sa);
		model.addAttribute("employees2",employees2);
		model.addAttribute("parts", parts);
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		return "part-out-update";
	
	}
	@RequestMapping("part-out-update.do")
	public String getpickerandid(HttpServletRequest request, Model model, @RequestParam(value = "Id")int Id,@RequestParam(value = "picker")int picker,@RequestParam(value = "orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		service.updatepicker(Id, picker);
		return "redirect:/showOrderandpart.do?orderId=" + orderId;
	}
	@RequestMapping("part-out-delet.do")
	public void deletpartByid(HttpServletRequest request, Model model, @RequestParam(value = "Id")int Id,@RequestParam(value = "orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		service.dedeletepart(Id);
		//return "redirect:/showOrderandpart.do?orderId=" + orderId;
	}
	@RequestMapping("part-show-insert.do")
	public String showinsert(@RequestParam(value = "orderId")String orderId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice  service = (partoutservice) ctx.getBean("partoutserviceDao");
		
		return "redirect:/showOrderandpart.do?orderId=" + orderId;
	}
}
