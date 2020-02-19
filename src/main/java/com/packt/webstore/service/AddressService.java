package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Address;
 
public interface AddressService {

	public Address save(Address address);
	public List<Address> findAll();
	public Address findById(long addressId);
	public void deleteById (Long addressId);
//	public String generateAddressID();
	
//	public Address findByAddressID(String addressID);
	
}
