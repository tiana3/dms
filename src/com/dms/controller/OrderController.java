package com.dms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//业务维修开单的空白页
	@RequestMapping("order.do")
	public String order(Model model) {
		return "orderIndex";
	}
	
	//订单中，搜索材料的显示详情
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
	//订单中选择添加材料
	@RequestMapping("addPart.do")
	public String addpart(Model model) {
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		model.addAttribute("carTypes", carTypeList);
		
		return "orderSelectPart";
	}
	//整单派工时查询所有工人
	@RequestMapping("allWorkSelect.do")
	public String allWorkSelect(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		List<Employee> Ma_Tec = service.getMa_Tec();
		model.addAttribute("Ma_Tec", Ma_Tec);
		
		return "orderWork";
	}
	
	//根据车牌或者VIN 获取到车辆客户信息，返回给页面
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
		
		if(carInfo!=null) {
			model.addAttribute("repairType", repairType);
			model.addAttribute("carInfo", carInfo);
			model.addAttribute("sa", sa);
			model.addAttribute("lastOrder", lastOrder);
			model.addAttribute("Ma_Tec", Ma_Tec);
			model.addAttribute("inspectors", inspectors);
		}				
		
		return "orderIndex";
	}
	
	// 保存新增维修单
	@ResponseBody
	@RequestMapping("orderSave.do")
	public String orderSave(Model model, Order order) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		Order saveOrder = service.saveOrder(order);
		
		String orderId = saveOrder.getOrderId();
		String date = saveOrder.getDate();
		
		return "{\"date\":\""+ date +"\",\"orderId\":\""+ orderId +"\"}";
	}
	
	//作废维修单
	@ResponseBody
	@RequestMapping("orderDelete.do")
	public String orderDelete(HttpServletResponse response,Model model, @RequestParam(value = "orderId") String orderId) throws IOException {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		service.deleteOrder(orderId);
        return "{\"data\":\"成功\"}";
	}
	//修改维修单
	@ResponseBody
	@RequestMapping("updateOrder.do")
	public String updateOrder(Model model, Order order) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		service.updateOrder(order);
		
		
		return "{\"data\":\"成功\"}";
	}
	
	
	@RequestMapping("theMaintenance.do")
	public String theMaintenance(Model model) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService) ctx.getBean("orderServiceImpl");
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		List<Order> allOrders = service.getAllOrders();
		
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		
		return "theMaintenance";
	}
	
	@RequestMapping("showOrder.do")
	public String showOrder(Model model,@RequestParam(value = "orderId") String orderId ) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService) ctx.getBean("orderServiceImpl");
	
		Order order = service.getOrderByOrderId(orderId);
		CustomerCarInfo carInfo = order.getCustomerCarInfo();
		List<RepairType> repairType = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		Order lastOrder = order;
		List<Employee> Ma_Tec = service.getMa_Tec();
		List<Employee> inspectors = service.getInspectors();
		
		if(carInfo!=null) {
			model.addAttribute("order", order);
			model.addAttribute("repairType", repairType);
			model.addAttribute("carInfo", carInfo);
			model.addAttribute("sa", sa);
			model.addAttribute("lastOrder", lastOrder);
			model.addAttribute("Ma_Tec", Ma_Tec);
			model.addAttribute("inspectors", inspectors);
		}	
		return "orderIndex";
	}
	
	@RequestMapping("getOrders.do")
	public String getOrders(Model model, @RequestParam(value = "orderId")String orderId, @RequestParam(value = "plateNumber")String plateNumber, @RequestParam(value = "employeeId")int employeeId, @RequestParam(value = "repairId")int repairId) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService) ctx.getBean("orderServiceImpl");
		List<RepairType> repairTypes = service.getAllRepairType();
		List<Employee> sa = service.getSA();
		List<Order> allOrders = service.getOrders(orderId, plateNumber, employeeId, repairId);
		
		model.addAttribute("allOrders", allOrders);
		model.addAttribute("repairType", repairTypes);
		model.addAttribute("sa", sa);
		
		return "theMaintenance";
	}
}
