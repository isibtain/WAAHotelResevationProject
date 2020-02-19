package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.RoomType;
import com.packt.webstore.domain.ViewType;
 
public interface ViewTypeService {

	public ViewType save(ViewType roomType);
	public List<ViewType> findAll();
	public ViewType findById(long viewTypeId);
	public void deleteById (Long viewTypeId);
	
	public ViewType findViewTypeByName(String name);
	public boolean used(Long id);
	
}
