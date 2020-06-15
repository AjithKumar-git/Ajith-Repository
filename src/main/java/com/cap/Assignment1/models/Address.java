package com.cap.Assignment1.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="addressId")
	private Integer addressId;
	@Column(name="StreetName")
	private String streetName;
	@Column(name="city")
	private String city;
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Employee employee;

	

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	
}
