package com.packt.webstore.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.User;
import com.packt.webstore.service.BookingService;
import com.packt.webstore.service.RoomService;
import com.packt.webstore.service.UserService;
 

@Controller
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("rooms")
	public List<Room> listRooms(){
		return roomService.findAll();
	}
	
	@ModelAttribute("users")
	public List<User> listUsers(){
		return userService.findAll();
	}
	
	@ModelAttribute("bookings")
	public List<Booking> listBookings(){
		return bookingService.findAll();
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("booking") Booking booking) {
	   return "addBooking";
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String saveBooking(@Valid @ModelAttribute("booking") Booking booking, BindingResult result,
			RedirectAttributes redirect) {
		if(result.hasErrors()) return "addBooking";			
		bookingService.saveNewCustomerBookingAdmin(booking);				
		redirect.addFlashAttribute("addedBooking", booking);				
		return "redirect:/addBooking";
	}
	
	@RequestMapping(value = "/deleteBooking/{bookingID}", method = RequestMethod.GET)
	public String removeBooking(@ModelAttribute("booking") Booking booking, @PathVariable("bookingID") String bookingID,
			RedirectAttributes redirect) {
		bookingService.deleteById(bookingService.findByBookingID(bookingID).getId());
		return "redirect:/addBooking";
	}
	
	@RequestMapping(value = "/book/{roomID}", method = RequestMethod.GET)
	public String customerBooking(@PathVariable String roomID, @ModelAttribute Booking booking, HttpServletRequest request) {
		request.getSession().setAttribute("roomId", roomID);
		return "customerBookingForm";
	}
	
	@RequestMapping(value = "/book/{roomID}", method = RequestMethod.POST)
	public String saveCustomerBooking(@Valid @ModelAttribute Booking booking,
			BindingResult result, Model model, 
			HttpServletRequest request) {
		if(result.hasErrors()) return "customerBookingForm";
		bookingService.saveNewCustomerBooking(booking, (Date) request.getSession().getAttribute("checkIn"), (Date) request.getSession().getAttribute("checkOut"));
		request.getSession().setAttribute("customerName", booking.getCustomer().getFirstName());
		request.getSession().setAttribute("roomType", booking.getRoom().getType().getName());
		return "redirect:/confirm";
	}
	
	@RequestMapping(value = "/confirm")
	public String confirmUser() {
		return "confirmation";
	}
 
}
