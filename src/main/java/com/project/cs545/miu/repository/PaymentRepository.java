package com.project.cs545.miu.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.Payment;
import com.project.cs545.miu.domain.Room;

@Repository
public interface PaymentRepository extends  CrudRepository<Payment, Long> 
{
	
}

