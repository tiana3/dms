package com.dms.servlet.cartype;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dms.service.CarTypeService;
import com.dms.service.impl.CarTypeServiceImpl;

/**
 * Servlet implementation class CarTypeRemoveServlet
 */
@WebServlet("/CarTypeRemoveServlet")
public class CarTypeRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
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
		if(powerIds.contains(14)){
			String stringId = request.getParameter("modelId");
			int modelId = Integer.parseInt(stringId);
			CarTypeService service = new CarTypeServiceImpl();
			service.removeCarType(modelId);
			response.getWriter().print("1");
		}else {
			response.getWriter().print("��û��ɾ��Ȩ��");
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
