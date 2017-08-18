package com.dms.servlet.partServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.impl.PartDaoImpl;
import com.dms.entity.CarType;
import com.dms.entity.Part;
import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

@WebServlet("/PartListServlet")
public class PartListServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String keyword1 = request.getParameter("partname");
		String keyword2 = request.getParameter("partno");
		String id = request.getParameter("modelid");
		Integer modelId = 0;
		if(id!=null) {
			modelId= Integer.parseInt(id);
		}
		Part part = new Part();
		part.setPartNo(keyword2);
		part.setModelId(modelId);
		part.setPartName(keyword1);
		
		PartDaoImpl imp = new PartDaoImpl();	
		List<Part> list = imp.getPart(part);
		request.setAttribute("partlist",list);
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		request.setAttribute("carTypes", carTypeList);

		
		request.getRequestDispatcher("/WEB-INF/partlist.jsp").forward(request, response);
		
	}	
	
}
