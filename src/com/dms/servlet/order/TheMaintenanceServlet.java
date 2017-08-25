package com.dms.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dms.entity.Order;
import com.dms.service.TheMaintenanceService;
/**
 * Servlet implementation class TheMaintenanceServlet
 */
@WebServlet("/TheMaintenanceServlet")
public class TheMaintenanceServlet extends HttpServlet {
	protected ApplicationContext ctx = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheMaintenanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String orderId = request.getParameter("orderId");
		String plateNumber = request.getParameter("plateNumber");
		String repairType = request.getParameter("repairType");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		TheMaintenanceService service = (TheMaintenanceService) ctx.getBean("TheMaintenanceServiceImpl");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
