package com.dms.servlet.empServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.EmployeeDao;
import com.dms.dao.impl.EmployeeDaoImpl;
import com.dms.entity.Employee;

/**
 * Servlet implementation class employeeInsert
 */
@WebServlet("/employeeInsert")
public class employeeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeInsert() {
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
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String IdCard = request.getParameter("idcard");
		PrintWriter out = response.getWriter();
		System.out.println(request.getParameter("jobid"));
		int id = Integer.parseInt(request.getParameter("jobid"));
		Employee employee = new Employee(1, name, gender, phone, IdCard, 1,"c", id, "b");
		System.out.println(name+" "+gender+" "+phone+" "+" "+IdCard+" "+id);
		EmployeeDao dao= new EmployeeDaoImpl();
		dao.addEmployee(employee);
		out.print("Ìí¼Ó³É¹¦");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
