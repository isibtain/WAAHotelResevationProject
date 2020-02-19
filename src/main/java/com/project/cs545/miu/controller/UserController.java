package com.project.cs545.miu.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cs545.miu.domain.Authority;
import com.project.cs545.miu.domain.User;
import com.project.cs545.miu.service.CredentialsService;
import com.project.cs545.miu.service.UserService;
  
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CredentialsService credentialsService;
	
	@ModelAttribute("users")
	public List<User> listUsers(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String signUp(@ModelAttribute User user, Model model) {
		return "addUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirect) {
		if(result.hasErrors()) return "addUser";
		String message = credentialsService.validate(user.getCredentials());
		if(message.equals("Success")) {
			user.setUserID(userService.generateUserID());
			userService.save(user);
			return "redirect:/addUser";
		}
		redirect.addFlashAttribute("credmessage", message);
		redirect.addFlashAttribute("addedUser", user);
		return "redirect:/addUser";
	}
	
	@RequestMapping(value = "/deleteUser/{userID}", method = RequestMethod.GET)
	public String removeUser(@ModelAttribute("user") User user, @PathVariable("userID") String userID,
			RedirectAttributes redirect) {
		if(userService.used(userID)) {
			redirect.addFlashAttribute("deleteError", "Cannot Delete USER: " + userID +" because user is associated with a current Booking");
			return "redirect:/addUser";
		}
		userService.deleteById(userService.findByUserID(userID).getUid());
		return "redirect:/addUser";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String customerSignUp(@ModelAttribute User user, Model model) {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String saveCustomerSignUp(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirect) {
		if(result.hasFieldErrors()) return "signup";
		String message = credentialsService.validate(user.getCredentials());
		if(message.equals("Success")) {
			Authority customerAuthority = new Authority();
			customerAuthority.setAuthority("CUSTOMER");
			user.getCredentials().setAuthority(customerAuthority);
			user.getCredentials().setEnabled(true);
			user.setUserID(userService.generateUserID());
			userService.save(user);
			redirect.addFlashAttribute("success", "Successfully Signed Up! You Can Now Login");
			return "redirect:/login";
		}
		redirect.addFlashAttribute("addedUser", user);
		redirect.addFlashAttribute("credmessage", message);
		return "redirect:/signup";
	}
}
