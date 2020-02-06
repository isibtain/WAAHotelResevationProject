package com.packt.webstore.service;

import java.util.List;
import com.packt.webstore.domain.RoomType;
 
public interface RoomTypeService {

	public RoomType save(RoomType roomType);
	public List<RoomType> findAll();
	public RoomType findById(long roomTypeId);
	public void deleteById (Long roomTypeId);
	
	public RoomType findRoomTypeByName(String name);
	
}
