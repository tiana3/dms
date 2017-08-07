package com.dms.servlet.whServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.WorkHourDao;
import com.dms.service.WorkHourService;

/**
 * Servlet implementation class WorkHourRemoveServlet
 */
@WebServlet("/WorkHourRemoveServlet")
public class WorkHourRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkHourRemoveServlet() {
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
		System.out.println(str);
		int workhourId = Integer.parseInt(str);
		WorkHourDao work = new WorkHourService();
		work.removeWorkHour(workhourId);
		response.sendRedirect(request.getContextPath() + "/WorkHourListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
