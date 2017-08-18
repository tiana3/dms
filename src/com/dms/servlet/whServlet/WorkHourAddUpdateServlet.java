package com.dms.servlet.whServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.entity.WorkHour;
import com.dms.service.WorkHourService;


/**
 * Servlet implementation class WorkHourServlet
 */
@WebServlet("/WorkHourAddUpdateServlet")
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
		
		String str = request.getParameter("workplaceId");
		if(str == null || str =="") {
			String workplaceName = request.getParameter("workplaceName");
			String workhour = request.getParameter("workhour");
			String workpay = request.getParameter("workpay");
			WorkHour workhou = new WorkHour();
			workhou.setWorkplaceName(workplaceName);
			workhou.setWorkhour(Double.parseDouble(workhour));
			workhou.setWorkpay(Double.parseDouble(workpay));
			WorkHourDao woho = new WorkHourService();
			woho.addWorkHour(workhou);
			response.getWriter().write("添加成功");
		}else {
			int workplaceId = Integer.parseInt(str);
			String workplaceName = request.getParameter("workplaceName");
			String workhour = request.getParameter("workhour");
			String workpay = request.getParameter("workpay");
			WorkHour workhou = new WorkHour(workplaceId,workplaceName,Double.parseDouble(workhour),Double.parseDouble(workpay));
			WorkHourDao woho = new WorkHourService();
			woho.updateWorkHour(workhou);
			response.getWriter().write("修改成功");
			response.sendRedirect(request.getContextPath()+ "/WorkHourListServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
