package com.packt.webstore.service.impl;

import java.util.List;

import com.packt.webstore.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.webstore.domain.Address;
import com.packt.webstore.service.AddressService;

@Service
@Transactional 
public class AdressServiceImpl implements AddressService {
	
 	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public List<Address> findAll() {
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public Address findById(long addressId) {
		return addressRepository.findById(addressId).get();
	}

	@Override
	public void deleteById(Long addressId) {
		addressRepository.deleteById(addressId);
	}

//	@Override
//	public String generateAddressID() {
//		Integer currentSize = this.findAll().size() + 1;
//		String zeros = "00";
//		if(currentSize > 9) zeros = "0";
//		if(currentSize > 99) zeros = "";
//		String addressID = "AD" + zeros +currentSize;
//		return addressID;
//	}

//	@Override
//	public Address findByAddressID(String addressID) {
//		return addressRepository.findByAddressId(addressID);
//	}
 

}
