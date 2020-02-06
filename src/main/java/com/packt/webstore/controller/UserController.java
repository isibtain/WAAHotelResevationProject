package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.User;
import com.packt.webstore.service.UserService;
  
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String signUp(@ModelAttribute User user, Model model) {
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redirect) {
		User newUser = user;
		userService.save(newUser);
		redirect.addFlashAttribute("addedUser", newUser);
		return "redirect:/userAdded";
	}
	
	@RequestMapping(value = "/userAdded")
	public String comfirmation() {
		return "userConfirmation";
	}
	
}
