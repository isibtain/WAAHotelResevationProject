package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.User;
 
public interface UserService {

	public User save(User customer);
	public List<User> findAll();
	public User findById(long customerId);
	public void deleteById (Long customerId);
	public String generateUserID();
	
	public User findByUserID(String userID);
	public boolean used(String id);
	
}
