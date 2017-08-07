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

/**
 * Servlet implementation class PartUpateServlet
 */
@WebServlet("/PartUpateServlet")
public class PartUpateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartUpateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PartDaoImpl imp = new PartDaoImpl();
			Part part = new Part();
			part.setPartName(request.getParameter("partname"));
			part.setPartNo(request.getParameter("partno"));
			part.setBuyingPrice(Double.parseDouble(request.getParameter("buyingprice")));
			part.setSellingPrice(Double.parseDouble(request.getParameter("sellingprice")));	
			part.setModelId(Integer.parseInt(request.getParameter("modelid")));
			imp.updatePart(part);
			System.out.println(part.getPartName()+" "+part.getPartNo()+" "+part.getModelId() );
			request.getRequestDispatcher("partlist.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}