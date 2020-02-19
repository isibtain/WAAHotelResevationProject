package com.project.cs545.miu.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.RoomType;

@Repository
public interface RoomTypeRepository extends  CrudRepository<RoomType, Long> 
{
	
	@Query("select t from RoomType t where t.name= :name")
	public RoomType findRoomTypeByName(@Param("name") String roomTypeName);
	
}

