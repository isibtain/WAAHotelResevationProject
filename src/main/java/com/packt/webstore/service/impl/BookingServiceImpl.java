package com.packt.webstore.service.impl;

import java.util.List;

import com.packt.webstore.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.service.BookingService;

@Service
@Transactional 
public class BookingServiceImpl implements BookingService {
	
 	@Autowired
	private BookingRepository bookingRepository;

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
 

}
