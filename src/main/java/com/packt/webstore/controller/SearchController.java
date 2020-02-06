package com.packt.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.service.SearchService;

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
	public String searchRoom(@ModelAttribute Booking booking, RedirectAttributes redirect) {
		System.out.println("is it comming?");
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
			return "redirect:/search";
		}
	}

}
