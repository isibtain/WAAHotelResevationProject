package com.project.cs545.miu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

 
@Entity
public class Credentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long crid;

	@NotEmpty(message="{NotEmpty.validation}")
	@Size(min = 4, max = 12, message="{Size.validation}")
 	String username;
	
	@NotEmpty(message="{NotEmpty.validation}")
	@Size(min = 4, max = 12, message="{Size.validation}")
	String password;
	
	String verifyPassword;
	
	Boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="username", referencedColumnName= "username") 
	Authority authority;   
	
 	public Credentials() {
	
	}
 	
 	public long getCrid() {
		return crid;
	}

	public void setCrid(long crid) {
		this.crid = crid;
	}

	public String getUsername() {
		return username;
	}
 	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}
	
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Authority getAuthority() {
		return authority;
	}
	
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
}
