package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.RoomType;
 
public interface RoomTypeService {

	public RoomType save(RoomType roomType);
	public List<RoomType> findAll();
	public RoomType findById(long roomTypeId);
	public void deleteById (Long roomTypeId);
	
	public RoomType findRoomTypeByName(String name);
	public boolean used(Long id);
	
}
