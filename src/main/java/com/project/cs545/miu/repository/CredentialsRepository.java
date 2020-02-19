package com.project.cs545.miu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cs545.miu.domain.Address;
import com.project.cs545.miu.domain.Credentials;

@Repository
public interface CredentialsRepository extends  CrudRepository<Credentials, Long>{
	
}
