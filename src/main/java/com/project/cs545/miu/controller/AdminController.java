package com.project.cs545.miu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String adminPage(Model model) {
		return "admin";
	}
	
}
