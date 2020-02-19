package com.project.cs545.miu.service;

import java.util.List;

import com.project.cs545.miu.domain.Address;
import com.project.cs545.miu.domain.Credentials;
 
public interface CredentialsService {
	
	public String validate(Credentials cred);
	public String verified(Credentials cred);
	
}
