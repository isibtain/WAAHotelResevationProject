package com.packt.webstore.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Payment;
import com.packt.webstore.domain.Room;

@Repository
public interface PaymentRepository extends  CrudRepository<Payment, Long> 
{
	
}

