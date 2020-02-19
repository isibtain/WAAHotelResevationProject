package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

	@RequestMapping("/index")
	public String welcome(Model model) {
		return "index";
	}
	
	@RequestMapping("/underConstruction")
	public String underConstruction(Model model) {
		return "accessDenied";
	}
	
}
