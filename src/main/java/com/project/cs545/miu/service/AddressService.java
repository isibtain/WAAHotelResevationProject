package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.Address;
 
public interface AddressService {

	public Address save(Address address);
	public List<Address> findAll();
	public Address findById(long addressId);
	public void deleteById (Long addressId);
//	public String generateAddressID();
	
//	public Address findByAddressID(String addressID);
	
}
