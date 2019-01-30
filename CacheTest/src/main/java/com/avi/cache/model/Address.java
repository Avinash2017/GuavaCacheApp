package com.avi.cache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "AVI_ADDRESS")
@Entity
public class Address {
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@javax.persistence.Id
	@Column(name = "address_id")
	private Integer addressId;
	
	@Column(name = "address_city")
	private String city;
	
	@Column(name = "address_state")
	private String state;
	
	@Column(name = "address_country")
	private String country;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
