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
	 * ҵ��ά�޿����Ŀհ�ҳ
	 * @param model
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("order.do")
	public void order(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			//ת������½ҳ
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				//��session��û�������Լ����õ�name��˵��û�е�¼��ת������½ҳ
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else {
				//ȡ��sessionȨ�ޣ��ж��Ƿ���п���Ȩ�ޡ����첽��ʽ���������ݸ�ajax�Ļص�����
				List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
				//1�����ݿ��Ȩ�ޱ�ʹ���ά�޿���
				PrintWriter writer = response.getWriter();
				if(powerIds.contains(1)){
					writer.write("{\"valid\":1,\"url\":\""+request.getContextPath()+"/orderIndex.do\"}");
				} else {
					writer.write("{\"valid\":0,\"message\":\"�Բ���û�п���Ȩ��\"}");
				}
				writer.close();
			}
				
		}

	}
	
	
	/**
	 * �����淽����֤���п���Ȩ�޺󣬻��ض����⣬������ת��������ҳ�档
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("orderIndex.do")
	public String orderIndex(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		//Ҫת��ǰ���ٴ��ж��Ƿ�����Ȩ�ޣ� ����û��Ȩ�޵��˻���¼��  ֱ������ ���url���뵽��
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(1)){
			return "orderIndex";
		}else{
			return "redirect:/login.jsp";
		}
		
	}
	
	//�����У��������ϵ���ʾ����
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
	//������ѡ����Ӳ���
	@RequestMapping("addPart.do")
	public String addpart(Model model,HttpServletRequest request) {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
	//�����ɹ�ʱ��ѯ���й���
	@RequestMapping("allWorkSelect.do")
	public String allWorkSelect(Model model, HttpServletRequest request) {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
	
	//���ݳ��ƻ���VIN ��ȡ�������ͻ���Ϣ�����ظ�ҳ��
	@RequestMapping("orderInfo.do")
	public String getCustomerCarInfoByPlateNumber(Model model, @RequestParam(value = "plateNumber") String plateNumber, @RequestParam(value = "VIN") String VIN, HttpServletRequest request) {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
	
	// ��������ά�޵�
	@RequestMapping("orderSave.do")
	public void orderSave(Model model, Order order, HttpServletRequest request, HttpServletResponse response) throws IOException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
		
		//��������������Ч��ֱ����ת������ҳ�档  ��Ȼ����ҳ�����֤�Ƿ���Ȩ��
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
	
	
	
	//����ά�޵�
	@RequestMapping("orderDelete.do")
	public void orderDelete(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "orderId") String orderId) throws IOException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
	
	
	
	//�޸�ά�޵�
	@RequestMapping("updateOrder.do")
	public String updateOrder(Model model, Order order,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		//��������������Ч��ֱ����ת������ҳ�档  ��Ȼ����ҳ�����֤�Ƿ���Ȩ��
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
	
	//���޵���ѯ
	@RequestMapping("theMaintenance.do")
	public String theMaintenance(Model model,HttpServletRequest request) {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
