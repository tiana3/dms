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
 * Servlet implementation class CarTypeAddUpdateServlet
 */
@WebServlet("/CarTypeAddUpdateServlet")
public class CarTypeAddUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stringId = request.getParameter("modelId");
		System.out.println(stringId);
		if (stringId == null || stringId == "") {
			String model = request.getParameter("model");
			String factory = request.getParameter("factory");
			CarType carType = new CarType();
			carType.setFactory(factory);
			carType.setModel(model);
			CarTypeService service = new CarTypeServiceImpl();
			service.addCarType(carType);
			response.getWriter().write("添加成功");
			
		} else {
			int modelId = Integer.parseInt(stringId);
			String model = request.getParameter("model");
			String factory = request.getParameter("factory");
			CarType carType = new CarType(modelId, factory, model);
			
			CarTypeService service = new CarTypeServiceImpl();
			service.updateCarType(carType);
			response.getWriter().write("修改成功");
			response.sendRedirect(request.getContextPath() + "/CarTypeListServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
