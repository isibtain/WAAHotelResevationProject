package com.packt.webstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
//	@NotNull(message = "{NotNull.validation}")
//	@Size(min = 4, max = 40, message="{Size.validation}")
    private String userName;
	
//	@NotNull(message = "{NotNull.validation}")
//	@Size(min = 4, max = 20, message="{Size.validation}")
    private String password;

    public User() {}

    public User(String firstName, String lastName, Address address, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.userName = userName;
		this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
