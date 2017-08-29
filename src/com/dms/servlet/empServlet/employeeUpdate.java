package com.dms.servlet.empServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dms.dao.impl.EmployeeDaoImpl;
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String employeid = request.getParameter("employeeid");
		int employeeid = Integer.parseInt(employeid);
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String IdCard = request.getParameter("idcard");
		PrintWriter out = response.getWriter();
		String jobname = null;
		String department = null;
		String id = request.getParameter("jobid");
		int jobid = Integer.parseInt(id);
		System.out.println(jobid);
		Employee employee = new Employee(employeeid, name, gender, phone, IdCard, employeeid,department,jobid, jobname);
		 new EmployeeDaoImpl().updateEmployee(employee);
		response.sendRedirect("employeelist");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
