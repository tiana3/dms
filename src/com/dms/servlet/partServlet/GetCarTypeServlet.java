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

/**
 * Servlet implementation class GetCarTypeServlet
 */
@WebServlet("/GetCarTypeServlet")
public class GetCarTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCarTypeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		CarTypeService service = new CarTypeServiceImpl();
		List<CarType> carTypeList = service.getAllCarType();
		request.setAttribute("carTypes", carTypeList);
		
		String act = request.getParameter("act");
		if (act == null) {
			request.getRequestDispatcher("/WEB-INF/partlist.jsp").forward(request, response);
		}else if ("add".equals(act)) {
			request.getRequestDispatcher("/WEB-INF/part-add.jsp").forward(request, response);
		}else if ("update".equals(act)) {
			String id = request.getParameter("partId");
			PartDaoImpl imp = new PartDaoImpl();
			Part part = imp.getPartById(Integer.parseInt(id));
			request.setAttribute("part", part);
			request.getRequestDispatcher("/WEB-INF/part-update.jsp").forward(request, response);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
