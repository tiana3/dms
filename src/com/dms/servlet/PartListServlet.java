package com.dms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.impl.PartDaoImpl;
import com.dms.entity.Part;

@WebServlet("/partlistervlet")
public class PartListServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
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
		int modelId= Integer.parseInt(request.getParameter("modelid"));
		PartDaoImpl imp = new PartDaoImpl();	
		List<Part> list = imp.getPart(keyword1 , keyword2 , modelId);
		request.setAttribute("partlist",list);
		request.getRequestDispatcher("/partlist.jsp").forward(request, response);
		
			}	
	
}
