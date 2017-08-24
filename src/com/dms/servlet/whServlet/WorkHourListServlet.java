package com.dms.servlet.whServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.dao.impl.WorkHourDaoImpl;
import com.dms.entity.WorkHour;
import com.dms.service.impl.WorkHourService;

/**
 * Servlet implementation class WorkHourListServlet
 */
@WebServlet("/WorkHourListServlet")
public class WorkHourListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");


			String str = request.getParameter("workplaceName");
			
			WorkHourDao dao1 = new WorkHourService();
			List<WorkHour> list = dao1.getWorkHour(str);
			
			request.setAttribute("work", list);
			request.getRequestDispatcher("/WEB-INF/workhour.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
