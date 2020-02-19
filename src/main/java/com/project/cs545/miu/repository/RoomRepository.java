package com.project.cs545.miu.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.Room;

@Repository
public interface RoomRepository extends  CrudRepository<Room, Long> {
	
	@Query("select r from Room r where r.roomID= :id")
	public Room findByRoomId(@Param("id") String roomID);
	
}

