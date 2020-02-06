package com.packt.webstore.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.packt.webstore.repository.BookingRepository;
import com.packt.webstore.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.service.SearchService;

@Service
@Transactional 
public class SearchServiceImpl implements SearchService {
	
 	@Autowired
	private BookingRepository bookingRepository;
 	
 	@Autowired
 	private RoomRepository roomRepository;

	@Override
	public List<Room> searchRooms(Date checkin, Date checkout) {
		
		List<Booking> allBookings = (List<Booking>) bookingRepository.findAll();
		List<Room> allRooms = (List<Room>) roomRepository.findAll();
		List<Room> availableRooms = new ArrayList<>();
		
		List<Room> booked = allBookings.stream().filter(b -> (b.getCheckInDate().before(checkin) &&
                b.getCheckOutDate().after(checkout)) || (b.getCheckInDate().after(checkin) &&
                b.getCheckInDate().before(checkout)) || (b.getCheckInDate().equals(checkin) ||
                b.getCheckInDate().equals(checkout) || b.getCheckOutDate().equals(checkin) ||
                b.getCheckOutDate().equals(checkout))).map(b -> b.getRoom()).collect(Collectors.toList());

        for(Room r: allRooms) if(!(booked.contains(r))) availableRooms.add(r);
        
		return availableRooms;
	}
 

}
