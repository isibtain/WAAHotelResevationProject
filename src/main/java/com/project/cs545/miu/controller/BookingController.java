package com.project.cs545.miu.controller;

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

import com.project.cs545.miu.domain.Booking;
import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.domain.User;
import com.project.cs545.miu.service.BookingService;
import com.project.cs545.miu.service.RoomService;
import com.project.cs545.miu.service.UserService;
 

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
	
	@RequestMapping(value = "/deleteMemberBooking/{bookingID}", method = RequestMethod.GET)
	public String removeMemberBooking(@ModelAttribute("booking") Booking booking, @PathVariable("bookingID") String bookingID,
			Model model) {
		bookingService.deleteById(bookingService.findByBookingID(bookingID).getId());
		model.addAttribute("hidden", "hidden");
		return "searchInput";
	}
	
	@RequestMapping(value = "/book/{roomID}", method = RequestMethod.GET)
	public String customerBooking(@PathVariable String roomID, @ModelAttribute Booking booking, HttpServletRequest request) {
		request.getSession().setAttribute("roomId", roomID);
		return "customerBookingForm";
	}
	
	@RequestMapping(value = "/memberBook/{roomID}", method = RequestMethod.GET)
	public String memberBooking(@PathVariable String roomID, HttpServletRequest request) {
		request.getSession().setAttribute("roomID", roomID);
		request.getSession().setAttribute("roomTypeName", roomService.findByRoomID(roomID).getType().getName());
		Double price = roomService.findByRoomID(roomID).getType().getPrice() + roomService.findByRoomID(roomID).getView().getPrice();
		request.getSession().setAttribute("bookingPrice", price);
		return "confirmBooking";
	}
	
	@RequestMapping(value = "/confirm")
	public String confirmUser() {
		return "confirmation";
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
	
	@RequestMapping(value = "/bookConfirm", method = RequestMethod.GET)
	public String saveMemberBooking(HttpServletRequest request) {
		String roomID = (String) request.getSession().getAttribute("roomID");
		String userID = (String) request.getSession().getAttribute("userID");
		Date checkIn = (Date) request.getSession().getAttribute("checkIn");
		Date checkOut = (Date) request.getSession().getAttribute("checkOut");
		bookingService.saveMemberBooking(roomID, userID, checkIn, checkOut);		
		return "redirect:/confirm";
	}
	
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageBooking(@ModelAttribute Booking booking, Model model, HttpServletRequest request) {
		List<Booking> bookings = bookingService.getCustomerBookings((String) request.getSession().getAttribute("userID"));
		System.out.println((String) request.getSession().getAttribute("userID"));
		System.out.println(bookings);
		if(bookings.size() == 0) {
			model.addAttribute("noBooking", "No Current Booking Found In Your Account");
			model.addAttribute("hidden", "hidden");
		}
		else {
			model.addAttribute("myBookings", bookings);
			model.addAttribute("hidden", "hidden");
		}
		return "searchInput";
	}
 
}
