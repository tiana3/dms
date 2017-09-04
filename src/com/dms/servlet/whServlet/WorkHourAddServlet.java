package com.dms.servlet.whServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.entity.CarType;
import com.dms.entity.WorkHour;
import com.dms.service.CarTypeService;
import com.dms.service.WorkHourService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class WorkHourAddServlet
 */
@WebServlet("/WorkHourAddServlet")
public class WorkHourAddServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkHourAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doPost(request, response);


    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		

		WorkHour work = new WorkHour();
		work.setWorkplaceName(request.getParameter("workplaceName"));
		work.setModelId(Integer.parseInt(request.getParameter("modelid")));
		work.setWorkhour(Double.parseDouble(request.getParameter("workhour")));
		work.setWorkpay(Double.parseDouble(request.getParameter("workpay")));
		WorkHourDao dao = new WorkHourService();
		dao.addWorkHour(work);
    }
}
