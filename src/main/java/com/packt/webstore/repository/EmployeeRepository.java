package com.packt.webstore.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.XEmployee;

	@Repository
	public interface EmployeeRepository extends  CrudRepository<XEmployee, Long> 
	{
		@Query("select e from XEmployee  e where e.id= :id")
		public XEmployee findByEmployeeNumber(@Param("id") Long employeeNumber);
 	}

