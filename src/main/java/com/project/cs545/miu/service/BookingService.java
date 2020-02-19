package com.project.cs545.miu.service;

import java.util.Date;
import java.util.List;

import com.project.cs545.miu.domain.Booking;
import com.project.cs545.miu.domain.Room;
 
public interface BookingService {

	public Booking save(Booking booking);
	public List<Booking> findAll();
	public Booking findById(long bookingId);
	public void deleteById (Long bookingId);
	public void setBookingPrice(Booking bookig);
	public String generateBookingID();
	
	public Booking findByBookingID(String bookingID);
	public void saveNewCustomerBooking(Booking booking, Date checkIn, Date checkOut);
	public void saveMemberBooking(String roomID, String userID, Date checkIn, Date checkOut);
	public void saveNewCustomerBookingAdmin(Booking booking);
	public List<Booking> getCustomerBookings (String userID);
	
}
