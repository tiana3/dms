package com.dms.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	protected ApplicationContext ctx = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String act = request.getParameter("act");
		if(act == null) {
			request.getRequestDispatcher("/WEB-INF/orderIndex.jsp").forward(request, response);
		} else if ("search".equals(act)) {
			String plateNumber = request.getParameter("plateNumber");
			String VIN = request.getParameter("VIN");
			CustomerCarInfoService  service = (CustomerCarInfoService) ctx.getBean("customerCarInfoServiceImpl");
			
			CustomerCarInfo carInfo = service.getCustomerCarInfoByKey(plateNumber, VIN);
			request.setAttribute("carInfo", carInfo);
			request.getRequestDispatcher("/WEB-INF/orderIndex.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
