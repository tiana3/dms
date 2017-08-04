package com.dms.servlet.cartype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class CarTypeRemoveServlet
 */
@WebServlet("/CarTypeRemoveServlet")
public class CarTypeRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stringId = request.getParameter("modelId");
		int modelId = Integer.parseInt(stringId);
		CarTypeService service = new CarTypeServiceImpl();
		service.removeCarType(modelId);
		response.sendRedirect(request.getContextPath() + "/CarTypeListServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
