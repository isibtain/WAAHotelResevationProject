package com.project.cs545.miu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cs545.miu.domain.Booking;
import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired 
	SearchService searchService;
	
	@ModelAttribute("hidden")
	public String hidden() {
		return "hidden";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchForm(@ModelAttribute Booking booking) {
		return "searchInput";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchRoom(@Valid @ModelAttribute Booking booking, BindingResult result, RedirectAttributes redirect,
			HttpServletRequest request) {
		if(result.hasErrors()) return "searchInput";
		List<Room> availableRooms = searchService.searchRooms(booking.getCheckInDate(), booking.getCheckOutDate());
		if(availableRooms.isEmpty()) {
			String message = "Sorry! No rooms are available for the chosen dates. Please Try different Dates";
			redirect.addFlashAttribute("roomMessage", message);
			redirect.addFlashAttribute("color", "red");
			return "redirect:/search";
		} else {
			String message = "Please Select Your Room Below";
			redirect.addFlashAttribute("roomMessage", message);
			redirect.addFlashAttribute("rooms", availableRooms);
			redirect.addFlashAttribute("color", "yellow");
			redirect.addFlashAttribute("hidden", "");
			redirect.addFlashAttribute("visible", "hidden");
			HttpSession bookingSession = request.getSession();
			bookingSession.setAttribute("checkIn", booking.getCheckInDate());
			bookingSession.setAttribute("checkOut", booking.getCheckOutDate());
			return "redirect:/search";
		}
	}

}
