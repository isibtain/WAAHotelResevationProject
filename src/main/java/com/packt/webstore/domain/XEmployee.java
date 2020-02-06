package com.packt.webstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class XEmployee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="{NotEmpty}")
	private String firstName;
	private String lastName;
 	private int age;
	private String title;
 	private int employeeNumber;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="addressid")
	private XAddress address;

	@OneToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="username") 
	private XCredentials credentials;

 	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
 	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public XAddress getAddress() {
		return address;
	}
	public void setAddress(XAddress address) {
		this.address = address;
	}
	public XCredentials getCredentials() {
		return credentials;
	}
	public void setCredentials(XCredentials credentials) {
		this.credentials = credentials;
	}
 
}
