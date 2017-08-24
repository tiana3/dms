package com.dms.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.impl.EmployeeDaoImlp;
import com.dms.dao.impl.PartDaoImpl;
import com.dms.entity.CarType;
import com.dms.entity.Employee;
import com.dms.entity.Part;
import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class employeelist
 */
@WebServlet("/employeelist")
public class employeelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeelist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String employeename = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String phone = request.getParameter("phone");
		Employee employee = new Employee();
		employee.setEmployeeName(employeename);
		employee.setIdCard(idcard);
		employee.setPhone(phone);
			
		List<Employee>list = EmployeeDaoImlp.getEmployee(employee);
		
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
