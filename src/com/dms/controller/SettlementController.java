package com.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettlementController {
	
	@RequestMapping("settlement.do")
	public String order(Model model) {
		return "settlement";
	}
	
	
}
