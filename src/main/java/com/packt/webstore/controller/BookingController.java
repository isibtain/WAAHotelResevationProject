package com.packt.webstore.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("biookings")
	public List<Booking> listBookings(){
		return bookingService.findAll();
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.GET)
	public String addBooking(@ModelAttribute("booking") Booking booking) {
	   return "addBooking";
	}
	
	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String saveBooking(@ModelAttribute("booking") Booking booking, RedirectAttributes redirect) {
		Room room = roomService.findByRoomID(booking.getRoom().getRoomID());
		User customer = userService.findByUserID(booking.getCustomer().getUserID());
		Date checkIn = booking.getCheckInDate();
		Date checkOut = booking.getCheckOutDate();
		Booking newBooking = new Booking(customer, room, checkIn, checkOut, true, true);
		newBooking.setBookingID(bookingService.generateBookingID());
		bookingService.save(newBooking);
		redirect.addFlashAttribute("addedBooking", newBooking);
		
		return "redirect:/addBooking";
	}
	
	@RequestMapping(value = "/bookingAdded")
	public String roomTypeAdded() {
		return "bookingConfirmation";
	}
 
}
