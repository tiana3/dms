package com.dms.servlet.whServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.dms.dao.WorkHourDao;
import com.dms.dao.impl.WorkHourDaoImpl;
import com.dms.entity.WorkHour;
import com.dms.service.WorkHourService;


/**
 * Servlet implementation class WorkHourServlet
 */
@WebServlet("/WorkHourServlet")
public class WorkHourAddUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkHourAddUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String str = request.getParameter("workhourId");
		if(str == null || str =="") {
			String workhourName = request.getParameter("workhourName");
			String workhou = request.getParameter("workhour");
			String workpay = request.getParameter("workpay");
			WorkHour workhour = new WorkHour();
			workhour.setWorkplaceName(workhourName);
			workhour.setWorkhour(Double.parseDouble(workhou));
			workhour.setWorkpay(Double.parseDouble(workpay));
			WorkHourDao woho = new WorkHourService();
			woho.addWorkHour(workhour);
			response.getWriter().write("添加成功");
		}else {
			String workhourName = request.getParameter("workhourName");
			String workhou = request.getParameter("workhour");
			String workpay = request.getParameter("workpay");
			WorkHour workhour = new WorkHour(workhourName,Double.parseDouble(workhou),Double.parseDouble(workpay));
			WorkHourDao woho = new WorkHourService();
			woho.updateWorkHour(workhour);
			response.getWriter().write("修改成功");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
