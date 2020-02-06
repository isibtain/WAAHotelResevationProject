package com.packt.webstore.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> 
{
	@Query("select u from User u where u.userID= :id")
	public User findByUserId(@Param("id") String userID);
}

