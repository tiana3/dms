package com.dms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dms.dao.impl.EmployeeDaoImlp;
import com.dms.entity.Employee;

/**
 * Servlet implementation class employeeUpdate
 */
@WebServlet("/employeeUpdate")
public class employeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int employeeid = (int) session.getAttribute("empid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String IdCard = request.getParameter("idcard");
		String jobname = request.getParameter("jobname");
		String department = request.getParameter("departmentname");
		Employee employee = new Employee(employeeid, name, gender, phone, IdCard, employeeid,department, employeeid, jobname);
		System.out.println(employeeid+" "+name+" "+gender+""+phone+""+IdCard+""+jobname+""+department);
		EmployeeDaoImlp.updateEmployee(employee);
		response.sendRedirect("employees.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
