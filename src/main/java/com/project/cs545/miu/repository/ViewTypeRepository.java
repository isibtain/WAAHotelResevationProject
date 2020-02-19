package com.project.cs545.miu.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.RoomType;
import com.project.cs545.miu.domain.ViewType;

@Repository
public interface ViewTypeRepository extends  CrudRepository<ViewType, Long> 
{
	
	@Query("select v from ViewType v where v.name= :name")
	public ViewType findViewTypeByName(@Param("name") String viewTypeName);
	
}

