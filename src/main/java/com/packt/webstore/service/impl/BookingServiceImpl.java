package com.packt.webstore.service.impl;

import java.util.Date;
import java.util.List;

import com.packt.webstore.repository.BookingRepository;
import com.packt.webstore.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.User;
import com.packt.webstore.service.BookingService;
import com.packt.webstore.service.UserService;

@Service
@Transactional 
public class BookingServiceImpl implements BookingService {
	
 	@Autowired
	private BookingRepository bookingRepository;
 	
 	@Autowired
	private RoomRepository roomRepository;
 	
 	@Autowired
	private UserService userService;

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}

	@Override
	public Booking findById(long bookingId) {
		return bookingRepository.findById(bookingId).get();
	}

	@Override
	public void deleteById(Long bookingId) {
		bookingRepository.deleteById(bookingId);
	}

	@Override
	public String generateBookingID() {
		Integer currentSize = this.findAll().size() + 1;
		String zeros = "00";
		if(currentSize > 9) zeros = "0";
		if(currentSize > 99) zeros = "";
		String bookingID = "BKG" + zeros +currentSize;
		return bookingID;
	}

	@Override
	public Booking findByBookingID(String bookingID) {
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingId(bookingID);
	}

	@Override
	public void setBookingPrice(Booking booking) {
		booking.setPrice(booking.getRoom().getType().getPrice() + booking.getRoom().getView().getPrice());
	}

	@Override
	public void saveNewCustomerBooking(Booking booking, Date checkIn, Date checkOut) {
		Room room = roomRepository.findByRoomId(booking.getRoom().getRoomID());
		booking.setBookingID(this.generateBookingID());
		booking.setRoom(room);
		booking.setCheckInDate(checkIn);
		booking.setCheckOutDate(checkOut);
		booking.getCustomer().setUserID(userService.generateUserID());
		this.setBookingPrice(booking);
		this.save(booking);
	}
	
	public void saveNewCustomerBookingAdmin(Booking booking) {
		Room room = roomRepository.findByRoomId(booking.getRoom().getRoomID());
		User customer = userService.findByUserID(booking.getCustomer().getUserID());
		booking.setBookingID(this.generateBookingID());
		booking.setCustomer(customer);
		booking.setRoom(room);
		this.setBookingPrice(booking);
		this.save(booking);
	}
 

}
