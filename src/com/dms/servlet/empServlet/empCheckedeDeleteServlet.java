package com.dms.servlet.empServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.EmployeeDao;
import com.dms.dao.impl.EmployeeDaoImpl;

/**
 * Servlet implementation class CheckedPartDeleteServlet
 */
@WebServlet("/empCheckedDeleteServlet")
public class empCheckedeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String employeeIdString = request.getParameter("employeeids");
		String[] employeeIds = employeeIdString.split(",");
		
		for (String employeeId: employeeIds) {
			EmployeeDao dao= new EmployeeDaoImpl();
			dao.removeEmployee(Integer.parseInt(employeeId));
		}
		response.getWriter().print("����ɾ���ɹ�");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
