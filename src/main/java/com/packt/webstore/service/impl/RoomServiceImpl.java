package com.packt.webstore.service.impl;

import java.util.List;

import com.packt.webstore.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.Room;
import com.packt.webstore.service.RoomService;

@Service
@Transactional 
public class RoomServiceImpl implements RoomService {
	
 	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room save(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public List<Room> findAll() {
		return (List<Room>) roomRepository.findAll();
	}

	@Override
	public Room findById(long roomId) {
		return roomRepository.findById(roomId).get();
	}

	@Override
	public void deleteById(Long roomId) {
		roomRepository.deleteById(roomId);
	}

	@Override
	public String generateRoomID() {
		Integer currentSize = this.findAll().size() + 1;
		String zeros = "00";
		if(currentSize > 9) zeros = "0";
		if(currentSize > 99) zeros = "";
		String roomID = "RM" + zeros +currentSize;
		return roomID;
	}

	@Override
	public Room findByRoomID(String roomID) {
		return roomRepository.findByRoomId(roomID);
	}
 

}
