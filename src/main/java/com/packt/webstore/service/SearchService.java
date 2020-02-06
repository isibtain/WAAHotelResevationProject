package com.packt.webstore.service;

import java.util.Date;
import java.util.List;
import com.packt.webstore.domain.Room;

public interface SearchService {
	
	public List<Room> searchRooms(Date checkin, Date checkout); 

}
