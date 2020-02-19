package com.packt.webstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Address;

@Repository
public interface AddressRepository extends  CrudRepository<Address, Long>{

//	@Query("select a from Address a where a.addressID= :id")
//	public Address findByAddressId(@Param("id") String addressID);
	
}
