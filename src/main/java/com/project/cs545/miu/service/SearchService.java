package com.project.cs545.miu.service;

import java.util.Date;
import java.util.List;

import com.project.cs545.miu.domain.Room;

public interface SearchService {
	
	public List<Room> searchRooms(Date checkin, Date checkout); 

}
