package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="address_tbl")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "street number should have atleast 3 character")
	private String streetNo;
	
	@NotNull
	@Size(min = 3, message = "street name should have atleast 3 character")
	private String streetName;
	

	@NotNull
	@Size(min = 3, message = "city name should have atleast 3 character")
	private String city;
	
	
	@NotNull
	@Size(min = 3, message = "state name should have atleast 3 character")
	private String state;
	
	
	@NotNull
	@Size(min = 3, message = "country name should have atleast 3 character")
	private String country;
	
	
	@NotNull
	@Size(min = 6, message = "pin code should have atleast 6 character")
	private String pincode;

	public Address() {
		super();
	}

	
	public Address(Long id, @Size(min = 3, message = "street number should have atleast 3 character") String streetNo,
			@Size(min = 3, message = "street name should have atleast 3 character") String streetName,
			@Size(min = 3, message = "city name should have atleast 3 character") String city,
			@Size(min = 3, message = "state name should have atleast 3 character") String state,
			@Size(min = 3, message = "country name should have atleast 3 character") String country,
			@Size(min = 6, message = "pin code should have atleast 6 character") String pincode) {
		super();
		this.id = id;
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}


	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", streetNo=" + streetNo + ", streetName=" + streetName + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

	


}