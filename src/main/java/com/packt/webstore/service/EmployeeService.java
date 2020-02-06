package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.XEmployee;
 
public interface EmployeeService {

	public void save(XEmployee employee);
	public List<XEmployee> findAll();
	public XEmployee findByEmployeeNumber(Long employeeId);
}
