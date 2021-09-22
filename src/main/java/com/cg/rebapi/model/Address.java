package com.cg.rebapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="aid")
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
	private Integer pincode;
	

	
	@OneToOne(mappedBy = "flatAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Flat flat;
	
	@OneToOne(mappedBy = "plotAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Plot plot;

	@OneToOne(mappedBy = "shopAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Shop shop;

	@OneToOne(mappedBy = "brokerAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Broker broker;
	
	@OneToOne(mappedBy = "customerAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(mappedBy = "ownerAddress", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Owner owner;
	
	public Address() {
		super();
	}

	
	


	





	public Address(Long id, @Size(min = 3, message = "street number should have atleast 3 character") String streetNo,
			@Size(min = 3, message = "street name should have atleast 3 character") String streetName,
			@Size(min = 3, message = "city name should have atleast 3 character") String city,
			@Size(min = 3, message = "state name should have atleast 3 character") String state,
			@Size(min = 3, message = "country name should have atleast 3 character") String country,
			@Size(min = 6, message = "pin code should have atleast 6 character") Integer pincode, Flat flat, Plot plot,
			Shop shop, Broker broker, Customer customer, Owner owner) {
		super();
		this.id = id;
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.flat = flat;
		this.plot = plot;
		this.shop = shop;
		this.broker = broker;
		this.customer = customer;
		this.owner = owner;
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

	public Integer getPincode() {
		return pincode;
	}
	
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Flat getFlat() {
		return flat;
	}


	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	


	public Plot getPlot() {
		return plot;
	}


	public void setPlot(Plot plot) {
		this.plot = plot;
	}


	public Shop getShop() {
		return shop;
	}


	public void setShop(Shop shop) {
		this.shop = shop;
	}


	public Broker getBroker() {
		return broker;
	}


	public void setBroker(Broker broker) {
		this.broker = broker;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", streetNo=" + streetNo + ", streetName=" + streetName + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

	


}