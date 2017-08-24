package com.dms.servlet.whServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.dao.impl.WorkHourDaoImpl;
import com.dms.entity.WorkHour;
import com.dms.service.WorkHourService;

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
//    	this.doPost(request, response);
    	
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String workhourName = request.getParameter("workplaceName");
		String workhour = request.getParameter("workhour");
		String workpay = request.getParameter("workpay");
		WorkHour work = new WorkHour();
		work.setWorkplaceName(workhourName);
		work.setWorkhour(Double.parseDouble(workhour));
		work.setWorkpay(Double.parseDouble(workpay));
		WorkHourDao dao = new WorkHourService();
		dao.addWorkHour(work);
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	doGet(request, response);
    	
//    	request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		
//		WorkHour work = new WorkHour();
//		work.setWorkplaceName(request.getParameter("workplaceName"));
//		work.setWorkhour(Double.parseDouble(request.getParameter("workhour")));
//		work.setWorkpay(Double.parseDouble(request.getParameter("workpay")));
//		
//		WorkHourDaoImpl imp = new WorkHourDaoImpl();
//		Integer workplaceId = imp.addWorkHour(work);
    }
}
