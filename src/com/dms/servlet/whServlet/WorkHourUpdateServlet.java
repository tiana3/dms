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
 * Servlet implementation class PartUpateServlet
 */
@WebServlet("/WorkHourUpdateServlet")
public class WorkHourUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WorkHourUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		WorkHourDaoImpl imp = new WorkHourDaoImpl();
		WorkHour work = new WorkHour();
		work.setWorkplaceId(Integer.parseInt(request.getParameter("workplaceId")));
		work.setWorkplaceName(request.getParameter("workplaceName"));
		work.setWorkpay(Double.parseDouble(request.getParameter("workpay")));
		String id = request.getParameter("modelid");
		work.setModelId(Integer.parseInt(request.getParameter("modelid")));	
		if(work != null) {
			request.setAttribute("work", work);
			imp.updateWorkHour(work);
		}
		
//		String str = request.getParameter("workplaceId");
//		int workplaceId = Integer.parseInt(str);
//		String workplaceName = request.getParameter("workplaceName");
//		String workhour = request.getParameter("workhour");
//		String workpay = request.getParameter("workpay");
//
//		WorkHour work = new WorkHour(workplaceId, workplaceName, Double.parseDouble(workhour),
//				Double.parseDouble(workpay));
//		WorkHourDao dao = new WorkHourService();
//		dao.updateWorkHour(work);
//		response.getWriter().write("ÐÞ¸Ä³É¹¦£¡");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
