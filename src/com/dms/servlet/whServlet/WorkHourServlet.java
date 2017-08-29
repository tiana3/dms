package com.dms.servlet.whServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.dao.impl.PartDaoImpl;
import com.dms.dao.impl.WorkHourDaoImpl;
import com.dms.entity.Part;
import com.dms.entity.WorkHour;
import com.dms.service.WorkHourService;



/**
 * Servlet implementation class WorkHourListServlet
 */
@WebServlet("/WorkHourServlet")
public class WorkHourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String act = request.getParameter("act");
		if (act == null) {
			request.getRequestDispatcher("/WEB-INF/workhour.jsp").forward(request, response);
		}else if ("add".equals(act)) {
			request.getRequestDispatcher("/WEB-INF/workhourAdd.jsp").forward(request, response);
		}else if ("update".equals(act)) {
			String workplaceId = request.getParameter("workplaceId");
			WorkHourDao dao = new WorkHourDaoImpl();
			WorkHour workhour= dao.getWorkHourById(Integer.parseInt(workplaceId));
			request.setAttribute("workhour", workhour);
			request.getRequestDispatcher("/WEB-INF/workhourUpdate.jsp").forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
