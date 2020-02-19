package com.project.cs545.miu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;

	private String userID;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String firstName;
	
	@NotEmpty(message="{NotEmpty.validation}")
    private String lastName;
    
	@Valid
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
	
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST) 
	private Credentials credentials;

	public User() {}

    public User(String firstName, String lastName, Address address, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
    
    public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
}
