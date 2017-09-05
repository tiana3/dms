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
	//登录验证
	@RequestMapping("login.do")
	public void login(Model model,HttpServletResponse response,HttpServletRequest request,@RequestParam(value="user")String user,@RequestParam(value="password")String password ) throws IOException, ServletException{
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService service = (AdminService) ctx.getBean("adminServiceImpl");
		AdminPowers adminPowers = service.getAdmin(user, password);
		
		if(adminPowers!=null){
			HttpSession session = request.getSession();
			//设置session数据在服务器保存一天，不然一会没用就要重新登录
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
	//退出账户
	@RequestMapping("logout.do")
	public String logout(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException{
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		return "redirect:/login.jsp";
	}
	
	
	//验证成功后会重定向到这，再重这重定向到 index首页 jsp
	@RequestMapping("index.do")
	public String index(Model model,HttpServletRequest request){
		//下面验证是否登录，登录正常跳转，否则跳转登录页
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
	
	//显示更改修改密码页面
	@RequestMapping("password.do")
	public String showPassword(Model model,HttpServletRequest request){
		//下面验证是否登录，登录正常跳转，否则跳转登录页
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
	
	//更改密码
	@RequestMapping("changePassword.do")
	public String changePassword(Model model,HttpServletResponse response, HttpServletRequest request,@RequestParam(value="oldPassword")String oldPassword, @RequestParam(value="newPassword")String newPassword) throws IOException{
		//下面验证是否登录，登录正常跳转，否则跳转登录页
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
