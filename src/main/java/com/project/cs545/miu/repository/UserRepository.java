package com.project.cs545.miu.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> 
{
	@Query("select u from User u where u.userID= :id")
	public User findByUserId(@Param("id") String userID);
}

