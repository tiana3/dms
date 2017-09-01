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
import com.dms.service.impl.CarTypeServiceImpl;
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
		
		
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		request.setAttribute("carTypes", carTypeList);
		
		String workplaceName = request.getParameter("workplaceName");
		String modelid = request.getParameter("modelid");
		Integer modelId = 0;
		if(modelid!=null) {
			modelId= Integer.parseInt(modelid);
		}
		WorkHour work =  new WorkHour();
		work.setWorkplaceName(workplaceName);
		work.setModelId(modelId);
		WorkHourDao dao1 = new WorkHourService();
		List<WorkHour> list = dao1.getWorkHour(work);
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
