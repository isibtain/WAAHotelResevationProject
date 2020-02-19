package com.packt.webstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.packt.webstore.repository.BookingRepository;
import com.packt.webstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Booking;
import com.packt.webstore.domain.Room;
import com.packt.webstore.domain.User;
import com.packt.webstore.service.UserService;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserRepository userRepository;
 	
 	@Autowired
	private BookingRepository bookingRepository;


	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findById(long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public String generateUserID() {
		Integer currentSize = this.findAll().size() + 1;
		String zeros = "00";
		if(currentSize > 9) zeros = "0";
		if(currentSize > 99) zeros = "";
		String userID = "UR" + zeros +currentSize;
		return userID;
	}

	@Override
	public User findByUserID(String userID) {
		return userRepository.findByUserId(userID);
	}
	
	@Override
	public boolean used(String id) {
		List<String> customerIds = ((List<Booking>) bookingRepository.findAll())
															 .stream().map(b -> b.getCustomer().getUserID())
															 .collect(Collectors.toList());
		if(customerIds.contains(id)) return true;
		return false;
	}
 

}
