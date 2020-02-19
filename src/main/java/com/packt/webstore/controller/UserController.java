package com.packt.webstore.controller;

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
import com.packt.webstore.domain.User;
import com.packt.webstore.domain.User;
import com.packt.webstore.service.UserService;
  
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
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
		if(result.hasFieldErrors()) return "addUser";
		User newUser = user;
		newUser.setUserID(userService.generateUserID());
		userService.save(newUser);
		redirect.addFlashAttribute("addedUser", newUser);
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
}
