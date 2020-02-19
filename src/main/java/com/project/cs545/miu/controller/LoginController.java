package com.project.cs545.miu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cs545.miu.domain.Credentials;
import com.project.cs545.miu.service.CredentialsService;
import com.project.cs545.miu.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	CredentialsService credentialsService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("credentials") Credentials credentials) {
 		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPost(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request) {
		String userID = credentialsService.verified(credentials);
		if(userID.equals("invalid")) {
			redirect.addFlashAttribute("loginmessage", "Invalid Username or Password");
	 		return "redirect:/loginfailed";		
		}
		String role = userService.findByUserID(userID).getCredentials().getAuthority().getAuthority();
		String alias = userService.findByUserID(userID).getFirstName();
		HttpSession loginSession = request.getSession();
		loginSession.setAttribute("userID", userID);
		loginSession.setAttribute("loggedUser", userService.findByUserID(userID));
		loginSession.setAttribute("role", role);
		loginSession.setAttribute("alias", alias);
		loginSession.setAttribute("log", "Log Out");
		loginSession.setAttribute("display", "display='block'");
		if(role.equals("ADMIN")) {
	 		return "redirect:/admin";
		}
 		return "redirect:/search";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(@ModelAttribute("credentials") Credentials credentials) {
		return "login";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
 		return "redirect:/login";
 	}
}
