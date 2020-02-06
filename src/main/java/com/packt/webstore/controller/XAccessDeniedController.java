package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class XAccessDeniedController {
	
  	@RequestMapping({"/accessDenied"})
	public String welcome(Model model) {
		return "xerror-forbidden";
	}
	
}
