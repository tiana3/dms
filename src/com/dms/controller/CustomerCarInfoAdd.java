package com.dms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dms.entity.CustomerCarInfo;
import com.dms.service.CustomerCarInfoService;

@Controller
public class CustomerCarInfoAdd {
	@RequestMapping("carinfo_add.do")
	public String requestAndResponse(HttpServletRequest request,
			HttpServletResponse reponses,
			Model model)
	{
		return "carinfo_add";
	}
	
	@RequestMapping("carinfoadd.do")												
	public void addCustomerCarInfo(CustomerCarInfo info){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerCarInfoService service = (CustomerCarInfoService)ctx.getBean("customerCarInfoServiceImpl");
		service.addCustomerCarInfo(info);	
	}
}
