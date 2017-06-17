package com.mindtree.model;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class Address {

	private String doorNo;
	private String street;
	private String location;
	private String city;

	public Address(String doorNo, String street, String location, String city) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.location = location;
		this.city = city;
	}

	public Address() {
		super();
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
