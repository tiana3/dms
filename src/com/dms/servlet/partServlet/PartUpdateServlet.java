package com.dms.servlet.partServlet;

import java.io.IOException;
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
@WebServlet("/PartUpdateServlet")
public class PartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartUpdateServlet() {
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
			part.setPartId(Integer.parseInt(request.getParameter("partid")));
			part.setPartName(request.getParameter("partname"));
			part.setPartNo(request.getParameter("partno"));
			part.setBuyingPrice(Double.parseDouble(request.getParameter("buyingprice")));
			part.setSellingPrice(Double.parseDouble(request.getParameter("sellingprice")));	
			part.setModelId(Integer.parseInt(request.getParameter("modelid")));			
			if(part != null){
				request.setAttribute("part",part);
				imp.updatePart(part);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
