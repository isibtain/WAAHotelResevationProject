package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.XEmployee;
import com.packt.webstore.service.EmployeeService;
 

@Controller
@RequestMapping({"/employees"})
public class XEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	@Autowired
//	private EmployeeValidator employeeValidator;

	@RequestMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "xemployees";
	}
	
  	@RequestMapping("/employee")
	public String getEmployeeById(Model model, @RequestParam("id") Long employeeId) {
		XEmployee employee = employeeService.findByEmployeeNumber(employeeId);
		model.addAttribute("employee", employee);
		return "employee";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewEmployeeForm(@ModelAttribute("newEmployee") XEmployee newEmployee) {
	   return "xaddEmployee";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployeeForm(@Valid @ModelAttribute("newEmployee")  XEmployee employeeToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "xaddEmployee";
		}

   		try {
			employeeService.save(employeeToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/employees/list";
	}
	
 
}
