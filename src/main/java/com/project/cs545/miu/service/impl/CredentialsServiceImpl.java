package com.project.cs545.miu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cs545.miu.domain.Credentials;
import com.project.cs545.miu.domain.User;
import com.project.cs545.miu.repository.CredentialsRepository;
import com.project.cs545.miu.repository.UserRepository;
import com.project.cs545.miu.service.AddressService;
import com.project.cs545.miu.service.CredentialsService;

@Service
@Transactional 
public class CredentialsServiceImpl implements CredentialsService {
	
 	@Autowired
	private CredentialsRepository credentialsRepository;
 	
 	@Autowired
	private UserRepository userRepository;

	@Override
	public String validate(Credentials cred) {
		List<String> usernames = ((List<Credentials>) credentialsRepository.findAll()).stream()
																					  .map(c -> c.getUsername())
																					  .collect(Collectors.toList());
		if(usernames.contains(cred.getUsername())) return "User Name Not Available";
		if(!(cred.getPassword().equals(cred.getVerifyPassword()))) return "Password Mismatch";
		return "Success";
	}

	@Override
	public String verified(Credentials cred) {
		for(User u : (List<User>)userRepository.findAll()) {
			if(u.getCredentials().getUsername().equals(cred.getUsername()) && u.getCredentials().getPassword().equals(cred.getPassword())) {
				return u.getUserID();
			}
		}
		return "invalid";
	}

	

}
