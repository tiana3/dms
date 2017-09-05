package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.AdminPowers;
import com.dms.service.AdminService;

@Controller
public class LoginController {
	//��¼��֤
	@RequestMapping("login.do")
	public void login(Model model,HttpServletResponse response,HttpServletRequest request,@RequestParam(value="user")String user,@RequestParam(value="password")String password ) throws IOException, ServletException{
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService service = (AdminService) ctx.getBean("adminServiceImpl");
		AdminPowers adminPowers = service.getAdmin(user, password);
		
		if(adminPowers!=null){
			HttpSession session = request.getSession();
			//����session�����ڷ���������һ�죬��Ȼһ��û�þ�Ҫ���µ�¼
			session.setMaxInactiveInterval(60*60*24);
			session.setAttribute("adminId", adminPowers.getAdminId());
			session.setAttribute("adminName", adminPowers.getAdminName());
			session.setAttribute("userName", adminPowers.getName());
			session.setAttribute("powerIds", adminPowers.getPowerIds());
			
			PrintWriter writer = response.getWriter();
			writer.print("{\"valid\":\"1\",\"url\":\""+ request.getContextPath() +"/index.do\"}");
			writer.close();
		}else{
			PrintWriter writer = response.getWriter();
			writer.print("{\"valid\":\"0\"}");
			writer.close();
		}
	}
	//�˳��˻�
	@RequestMapping("logout.do")
	public String logout(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException{
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		return "redirect:/login.jsp";
	}
	
	
	//��֤�ɹ�����ض����⣬�������ض��� index��ҳ jsp
	@RequestMapping("index.do")
	public String index(Model model,HttpServletRequest request){
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		
		
		return "index";
	}
	
	//��ʾ�����޸�����ҳ��
	@RequestMapping("password.do")
	public String showPassword(Model model,HttpServletRequest request){
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		
		return "changePassword";
	}
	
	//��������
	@RequestMapping("changePassword.do")
	public String changePassword(Model model,HttpServletResponse response, HttpServletRequest request,@RequestParam(value="oldPassword")String oldPassword, @RequestParam(value="newPassword")String newPassword) throws IOException{
		//������֤�Ƿ��¼����¼������ת��������ת��¼ҳ
		HttpSession session = request.getSession(false);
		if(session==null){
			return "redirect:/login.jsp";
		} else {
			String name = (String) session.getAttribute("userName");
			if(name==null) {
				return "redirect:/login.jsp";
			}
		}
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService service = (AdminService) ctx.getBean("adminServiceImpl");
		AdminPowers adminPowers = service.getAdmin((String)session.getAttribute("adminName"), oldPassword);

		
		if(adminPowers!=null){
			service.changePassword((Integer)session.getAttribute("adminId"), newPassword);
			PrintWriter writer = response.getWriter();
			writer.print(true);
			writer.close();
			return null;
		}else{
			PrintWriter writer = response.getWriter();
			writer.print(false);
			writer.close();
			return null;
		}
	}
}
