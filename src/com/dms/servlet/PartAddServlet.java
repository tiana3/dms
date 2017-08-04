package com.dms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.impl.PartDaoImpl;
import com.dms.entity.Part;

/**
 * Servlet implementation class PartServlet
 */
@WebServlet("/PartServlet")
public class PartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		Part part = new Part();
		part.setPartName(request.getParameter("partname"));
		part.setPartNo(request.getParameter("partno"));
		part.setModelId(Integer.parseInt(request.getParameter("modelid")));
		part.setBuyingPrice(Double.parseDouble(request.getParameter("buyingprice")));
		part.setSellingPrice(Double.parseDouble(request.getParameter("sellingprice")));
		PartDaoImpl  imp = new PartDaoImpl();
		imp.addPart(part);
		request.getRequestDispatcher("charts-8.jsp").forward(request, response);
		System.out.println(part.toString());
	}

}
