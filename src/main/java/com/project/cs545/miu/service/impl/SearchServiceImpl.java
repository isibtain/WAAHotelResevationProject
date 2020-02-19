package com.project.cs545.miu.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cs545.miu.domain.Booking;
import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.repository.BookingRepository;
import com.project.cs545.miu.repository.RoomRepository;
import com.project.cs545.miu.service.SearchService;

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
		List<Room> booked = allBookings.stream()
					.filter(b -> (b.getCheckInDate().before(checkin) && b.getCheckOutDate().after(checkin)) || 
							     (b.getCheckInDate().after(checkin) && b.getCheckInDate().before(checkout)) ||
							     (b.getCheckInDate().compareTo(checkin) == 0) || 
							     (b.getCheckInDate().compareTo(checkout) == 0)||
							     (b.getCheckOutDate().compareTo(checkin) == 0)||
							     (b.getCheckOutDate().compareTo(checkout) == 0)).map(b -> b.getRoom()).collect(Collectors.toList());
		
		List<String> roomIDs = booked.stream().map(b -> b.getRoomID()).collect(Collectors.toList());
        for(Room r: allRooms) if(!(roomIDs.contains(r.getRoomID()))) availableRooms.add(r);               
		return availableRooms;
	}
 

}
