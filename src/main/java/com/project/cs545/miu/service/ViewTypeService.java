package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.RoomType;
import com.project.cs545.miu.domain.ViewType;
 
public interface ViewTypeService {

	public ViewType save(ViewType roomType);
	public List<ViewType> findAll();
	public ViewType findById(long viewTypeId);
	public void deleteById (Long viewTypeId);
	
	public ViewType findViewTypeByName(String name);
	public boolean used(Long id);
	
}
