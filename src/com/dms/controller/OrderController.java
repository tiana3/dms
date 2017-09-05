package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * 业务维修开单的空白页
	 * @param model
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("order.do")
	public void order(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			//转发到登陆页
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				//有session，没有我们自己设置的name就说明没有登录，转发到登陆页
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else {
				//取出session权限，判断是否具有开单权限。以异步方式，返回数据给ajax的回调函数
				List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
				//1在数据库的权限表就代表维修开单
				PrintWriter writer = response.getWriter();
				if(powerIds.contains(1)){
					writer.write("{\"valid\":1,\"url\":\""+request.getContextPath()+"/orderIndex.do\"}");
				} else {
					writer.write("{\"valid\":0,\"message\":\"对不起，没有开单权限\"}");
				}
				writer.close();
			}
				
		}

	}
	
	
	/**
	 * 再上面方法验证具有开单权限后，会重定向到这，再由这转发到开单页面。
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("orderIndex.do")
	public String orderIndex(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		//要转发前，再次判断是否数据权限， 避免没有权限的账户登录后，  直接输入 这的url进入到这
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(1)){
			return "orderIndex";
		}else{
			return "redirect:/login.jsp";
		}
		
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
	public String addpart(Model model,HttpServletRequest request) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		model.addAttribute("carTypes", carTypeList);
		
		return "orderSelectPart";
	}
	//整单派工时查询所有工人
	@RequestMapping("allWorkSelect.do")
	public String allWorkSelect(Model model, HttpServletRequest request) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		List<Employee> Ma_Tec = service.getMa_Tec();
		model.addAttribute("Ma_Tec", Ma_Tec);
		
		return "orderWork";
	}
	
	//根据车牌或者VIN 获取到车辆客户信息，返回给页面
	@RequestMapping("orderInfo.do")
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN, HttpServletRequest request) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		
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
	@RequestMapping("orderSave.do")
	public void orderSave(Model model, Order order, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		}
		
		//如果保存的数据无效，直接跳转到开单页面。  当然开单页面会验证是否有权限
		if(order.getCustomerCarInfo()==null||order.getMileage()==null||order.getSenderPhone()==null){
			response.sendRedirect(request.getContextPath()+"/orderIndex.do");
			return;
		}
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
		Order saveOrder = service.saveOrder(order);
		
		String orderId = saveOrder.getOrderId();
		String date = saveOrder.getDate();
		PrintWriter writer = response.getWriter();
		writer.print("{\"date\":\""+ date +"\",\"orderId\":\""+ orderId +"\"}");
		writer.close();
	}
	
	
	
	//作废维修单
	@RequestMapping("orderDelete.do")
	public void orderDelete(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "orderId") String orderId) throws IOException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		}
		
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(2)){
			ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
			OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
			service.deleteOrder(orderId);
			response.getWriter().print("{\"valid\":1}");
		}else{
			response.getWriter().print("{\"valid\":0}");
		}
		
	}
	
	
	
	//修改维修单
	@RequestMapping("updateOrder.do")
	public String updateOrder(Model model, Order order,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		//如果保存的数据无效，直接跳转到开单页面。  当然开单页面会验证是否有权限
		if(order.getCustomerCarInfo()==null||order.getMileage()==null||order.getSenderPhone()==null){
			return "redirect:/orderIndex.do";
		}
		
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(3)){
			ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
			OrderService  service = (OrderService)ctx.getBean("orderServiceImpl");
			service.updateOrder(order);
			PrintWriter writer = response.getWriter();
			writer.print(true);
			writer.close();
			return null;
		}else{
			return "redirect:/login.jsp";
		}
		
		
	}
	
	//在修单查询
	@RequestMapping("theMaintenance.do")
	public String theMaintenance(Model model,HttpServletRequest request) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
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
	public String showOrder(Model model,HttpServletRequest request,@RequestParam(value = "orderId") String orderId ) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(1)){
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
		}else{
			return "redirect:/login.jsp";
		}
	}
	
	@RequestMapping("getOrders.do")
	public String getOrders(Model model,HttpServletRequest request, @RequestParam(value = "orderId")String orderId, @RequestParam(value = "plateNumber")String plateNumber, @RequestParam(value = "employeeId")int employeeId, @RequestParam(value = "repairId")int repairId) {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(4)){
			
			ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
			OrderService  service = (OrderService) ctx.getBean("orderServiceImpl");
			List<RepairType> repairTypes = service.getAllRepairType();
			List<Employee> sa = service.getSA();
			List<Order> allOrders = service.getOrders(orderId, plateNumber, employeeId, repairId);
			model.addAttribute("allOrders", allOrders);
			model.addAttribute("repairType", repairTypes);
			model.addAttribute("sa", sa);
			return "theMaintenance";
		}else{
			return "redirect:/login.jsp";
		}
	}
}
