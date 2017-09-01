package com.dms.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dms.entity.PartOut;
import com.dms.service.partoutservice;

@Controller
public class PartOutListController {

	
	@RequestMapping("partout.do")
	public String partout(Model modeld){
		return "part-out";
	}

	
	
	@RequestMapping("partoutlist.do")
	public String getPartOutByJSP(Model model,@RequestParam(value = "orderId",required=false) String orderId,@RequestParam(value = "plateNumber",required=false) String plateNumber,@RequestParam(value = "name",required=false) String name,@RequestParam(value = "repairTypeId",required=false) String repairtypeId)
	{
		Integer repairTypeId = 0;
		if(repairtypeId != null)
		{
			repairTypeId = Integer.parseInt(repairtypeId);
		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice service = (partoutservice)ctx.getBean("partoutServiceDao");
		ArrayList<PartOut>list2 = service.getpartoutByJSP(orderId, plateNumber, name, repairTypeId);
		ArrayList<PartOut>list = service.getrepairtype();
		ArrayList<PartOut>list3 = service.getemployees();
		ArrayList<PartOut>list5 = service.getemployeefu();
		System.out.println(list2.toString());
		
//		System.out.println(list4.toString());
		for (PartOut e : list3) {
			for (PartOut o : list2) {
				if (e.getRepairtypeid() == o.getEmployeeid()) {
					o.setPicker(e.getRepairtype());
				}
			}
		}
		model.addAttribute("list5",list5);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		return "part-out";
	}
	@RequestMapping("partoutU.do")
	public String partoutupdate(Model model,@RequestParam(value = "orderId",required=false) String orderId){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		partoutservice service = (partoutservice)ctx.getBean("partoutServiceDao");
		ArrayList<PartOut>list2 = service.getpartoutByJSP(orderId,null, null, 0);
		ArrayList<PartOut>list = service.getpartwithorder(orderId);
		model.addAttribute("list2", list2);
		System.out.println(list);
		model.addAttribute("list",list);
		
		return "part-out-update";
	}
}
