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
import com.dms.entity.CarType;
import com.dms.entity.Employee;
import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class employeeshow
 */
@WebServlet("/employeeshow")
public class employeeshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeshow() {
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
		
		String act = request.getParameter("act");
		if(act == null) {
			ArrayList<Employee>list = EmployeeDaoImlp.getJob();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/employeeinsert.jsp").forward(request, response);
		} else if("update".equals(act)) {
			String id = request.getParameter("id");
			System.out.println(id);
			ArrayList<Employee>list1 = EmployeeDaoImlp.getJob();
			Employee employee = EmployeeDaoImlp.getEmployeeById(Integer.parseInt(id));
			request.setAttribute("employee", employee);
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("/WEB-INF/employeeUpdate.jsp").forward(request, response);
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
