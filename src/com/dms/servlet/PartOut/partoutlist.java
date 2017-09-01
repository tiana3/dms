//package com.dms.servlet.PartOut;
//
//import java.io.IOException;
//import java.lang.reflect.Parameter;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.dms.dao.impl.EmployeeDaoImpl;
//
//import com.dms.dao.impl.PartOutDaoimpl2;
//import com.dms.entity.Employee;
//
//import com.dms.entity.PartOut;
//
///**
// * Servlet implementation class partoutlist
// */
//@WebServlet("/partoutlist")
//public class partoutlist extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public partoutlist() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String orderid = request.getParameter("orderid");
//		System.out.println(orderid);
//		String platenumber = request.getParameter("platenumber");
//		String vin = request.getParameter("vin");
//		String repairtypeid = request.getParameter("repairtypeid");
//		Integer repaid = 0;
//		if (repairtypeid != null) {
//			repaid = Integer.parseInt(repairtypeid);
//		}
//		PartOut partout = new PartOut(orderid, platenumber, vin, repaid, null, null, null, null, null, null);
//		PartOutDaoimpl2 part = new PartOutDaoimpl2();
//		ArrayList<PartOut> list = part.getrepairtype();
//		ArrayList<PartOut> list2 = part.getpartoutByJSP(partout);
//		ArrayList<PartOut> list3 = part.getemployees();
//		ArrayList<PartOut> list5 = list3;
//		List<PartOut> list4 = part.getpart();
//		System.out.println(list3.toString());
//		for (PartOut e : list5) {
//			for (PartOut o : list2) {
//				if (e.getRepairtypeid() == o.getEmployeeid()) {
//					o.setPicker(e.getRepairtype());
//				}
//			}
//		}
//		request.setAttribute("list2", list2);
//		request.setAttribute("list", list);
//		request.setAttribute("list3", list3);
//		request.setAttribute("list4", list4);
//		request.getRequestDispatcher("part-out.jsp").forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
