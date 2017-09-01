package com.dms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("login.do")
	public void login(Model model,HttpServletResponse response,HttpServletRequest request,@RequestParam(value="user")String user,@RequestParam(value="password")String password ) throws IOException, ServletException{
		int i = 1;
		if(i==1){                                                    
			response.getWriter().print("{\"valid\":\"1\",\"url\":\""+ request.getContextPath() +"/index.do\"}");
		}else{
			response.getWriter().print("{\"valid\":\"0\"}");
		}
	}
	
	@RequestMapping("index.do")
	public String index(Model model){
		return "index";
	}
}
