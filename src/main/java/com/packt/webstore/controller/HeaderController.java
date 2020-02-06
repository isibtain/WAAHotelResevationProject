package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.EmployeeService;
  
@Controller
public class HeaderController {
	
//	@RequestMapping("/searchForm")
//	public String searchForm(Model model) {
//		return "searchInput";
//	}
	
	@RequestMapping("/review")
	public String reviewPage(Model model) {
		return "review";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
}
