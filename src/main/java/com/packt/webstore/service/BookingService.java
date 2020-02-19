package com.packt.webstore.service;

import java.util.Date;
import java.util.List;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
 
public interface BookingService {

	public Booking save(Booking booking);
	public List<Booking> findAll();
	public Booking findById(long bookingId);
	public void deleteById (Long bookingId);
	public void setBookingPrice(Booking bookig);
	public String generateBookingID();
	
	public Booking findByBookingID(String bookingID);
	public void saveNewCustomerBooking(Booking booking, Date checkIn, Date checkOut);
	public void saveNewCustomerBookingAdmin(Booking booking);
	
}
