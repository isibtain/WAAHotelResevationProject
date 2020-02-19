package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.Room;
import com.project.cs545.miu.domain.User;
 
public interface UserService {

	public User save(User customer);
	public List<User> findAll();
	public User findById(long customerId);
	public void deleteById (Long customerId);
	public String generateUserID();
	
	public User findByUserID(String userID);
	public boolean used(String id);
	public boolean isMember(String userID);
	
}
