package com.packt.webstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.packt.webstore.repository.EmployeeRepository;
import com.packt.webstore.repository.RoomRepository;
import com.packt.webstore.repository.RoomTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.RoomType;
import com.packt.webstore.domain.XEmployee;
import com.packt.webstore.service.EmployeeService;
import com.packt.webstore.service.RoomTypeService;

@Service
@Transactional 
public class RoomTypeServiceImpl implements RoomTypeService {
	
 	@Autowired
	private RoomTypeRepository roomTypeRepository;
 	
 	@Autowired
	private RoomRepository roomRepository;

	@Override
	public RoomType save(RoomType roomType) {
		return roomTypeRepository.save(roomType);
	}

	@Override
	public List<RoomType> findAll() {
		return (List<RoomType>) roomTypeRepository.findAll();
	}

	@Override
	public RoomType findById(long roomTypeId) {
		return roomTypeRepository.findById(roomTypeId).get();
	}

	@Override
	public void deleteById(Long roomTypeId) {
		roomTypeRepository.deleteById(roomTypeId);
	}

	@Override
	public RoomType findRoomTypeByName(String name) {
		return roomTypeRepository.findRoomTypeByName(name);
	}

	@Override
	public boolean used(Long id) {
		List<Long> roomTypeIds = ((List<Room>) roomRepository.findAll())
															 .stream().map(r -> r.getType().getId())
															 .collect(Collectors.toList());
		if(roomTypeIds.contains(id)) return true;
		return false;
	}
 

}
