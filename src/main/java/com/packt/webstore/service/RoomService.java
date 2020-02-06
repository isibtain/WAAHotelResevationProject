package com.packt.webstore.service;

import java.util.List;
import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.RoomType;
 
public interface RoomService {

	public Room save(Room room);
	public List<Room> findAll();
	public Room findById(long roomId);
	public void deleteById (Long roomId);
	public String generateRoomID();
	
	public Room findByRoomID(String roomID);
	
}
