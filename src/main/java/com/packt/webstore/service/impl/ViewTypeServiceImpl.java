package com.packt.webstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.packt.webstore.repository.RoomRepository;
import com.packt.webstore.repository.ViewTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.ViewType;
import com.packt.webstore.service.ViewTypeService;

@Service
@Transactional 
public class ViewTypeServiceImpl implements ViewTypeService {
	
 	@Autowired
	private ViewTypeRepository viewTypeRepository;
 	
 	@Autowired
	private RoomRepository roomRepository;

	@Override
	public ViewType save(ViewType viewType) {
		return viewTypeRepository.save(viewType);
	}

	@Override
	public List<ViewType> findAll() {
		return (List<ViewType>) viewTypeRepository.findAll();
	}

	@Override
	public ViewType findById(long viewTypeId) {
		return viewTypeRepository.findById(viewTypeId).get();
	}

	@Override
	public void deleteById(Long viewTypeId) {
		viewTypeRepository.deleteById(viewTypeId);
	}

	@Override
	public ViewType findViewTypeByName(String name) {
		return viewTypeRepository.findViewTypeByName(name);
	}
	
	@Override
	public boolean used(Long id) {
		List<Long> viewTypeIds = ((List<Room>) roomRepository.findAll())
															 .stream().map(r -> r.getView().getId())
															 .collect(Collectors.toList());
		if(viewTypeIds.contains(id)) return true;
		return false;
	}
 

}
