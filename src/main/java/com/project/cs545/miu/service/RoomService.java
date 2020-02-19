package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.domain.RoomType;
 
public interface RoomService {

	public Room save(Room room);
	public List<Room> findAll();
	public Room findById(long roomId);
	public void deleteById (Long roomId);
	public String generateRoomID();
	
	public Room findByRoomID(String roomID);
	
}
