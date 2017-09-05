package com.dms.servlet.cartype;

import java.io.IOException;
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
 * Servlet implementation class CarTypeShowServlet
 */
@WebServlet("/CarTypeShowServlet")
public class CarTypeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
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
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(powerIds.contains(15)&&powerIds.contains(13)){
			String act = request.getParameter("act");
			if(act == null) {
				
			} else if("update".equals(act)) {
				String modelId = request.getParameter("modelId");
				CarTypeService service = new CarTypeServiceImpl();
				CarType carType = service.getCarTypeById(Integer.parseInt(modelId));
				request.setAttribute("carType", carType);
			}
			request.getRequestDispatcher("/WEB-INF/cartypeAddUpdate.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;
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
