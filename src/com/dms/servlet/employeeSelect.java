package com.dms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dms.dao.impl.EmployeeDaoImlp;
import com.dms.entity.Employee;



/**
 * Servlet implementation class employeeSelect
 */
@WebServlet("/employeeSelect")
public class employeeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("selectname");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ArrayList<Employee>employee = EmployeeDaoImlp.getEmployee(name);
		boolean c = false;
		for(Employee e:employee){
		if(name.equals(e.getEmployeeName()))
		{
			System.out.println(name);
			response.sendRedirect("employeeselect.jsp");
			HttpSession ssion = request.getSession();
			ssion.setAttribute("employeename", name);
			c = true;
		}
	}
		if(c = false)
		{
			System.out.println(" 6666666");
				out.print("<h1>不存在此用户</h1>");
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
