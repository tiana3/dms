package com.dms.servlet.cartype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.entity.CarType;
import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class CarTypeShowServlet
 */
@WebServlet("/CarTypeShowServlet")
public class CarTypeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String act = request.getParameter("act");
		if(act == null) {
			
		} else if("update".equals(act)) {
			String modelId = request.getParameter("modelId");
			CarTypeService service = new CarTypeServiceImpl();
			CarType carType = service.getCarTypeById(Integer.parseInt(modelId));
			request.setAttribute("carType", carType);
		}
		request.getRequestDispatcher("/WEB-INF/cartypeAddUpdate.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
