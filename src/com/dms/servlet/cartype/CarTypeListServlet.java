package com.dms.servlet.cartype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dms.entity.CarType;
import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class CarTypeServlet
 */
@WebServlet("/CarTypeListServlet")
public class CarTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下面验证是否登录，登录正常跳转，否则跳转登录页
		HttpSession session = request.getSession(false);
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		}
		
		List<Integer> powerIds = (List<Integer>) session.getAttribute("powerIds");
		if(powerIds.contains(16)){
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			CarTypeService service = new CarTypeServiceImpl();
			List<CarType> list = service.getAllCarType();
		
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/WEB-INF/cartypelist.jsp").forward(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			writer.write("{\"valid\":0,\"message\":\"对不起，没有查询车辆型号权限\"}");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
