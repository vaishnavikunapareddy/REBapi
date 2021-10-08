package com.cg.rebapi.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="broker")
public class Broker {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	@Size(min=2, message="first name should contain minimum 2 characters")
	private String brokerFirstName;
	@NotNull
	@Size(min=2, message="last name should contain minimum 2 characters")
	private String brokerLastName;
	@NotNull
	private Long contact;
	@NotNull
	@Email
	private String email;
	//mapping with address
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id")
    private Address brokerAddress;
	
	
	//mapping with customer
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="broker_id", referencedColumnName = "id")
	List<Customer> customerList= new ArrayList<Customer>();
	
	//mapping with flat
	@OneToMany
	@JoinColumn(name="broker_id",referencedColumnName = "id")
	List<Flat> flatList=new ArrayList<Flat>();
	/*mapping with plot*/
	@OneToMany
	@JoinColumn(name="broker_id",referencedColumnName = "id")
	List<Plot> plotList=new ArrayList<Plot>();
	/*mapping with shop*/
	@OneToMany
	@JoinColumn(name="broker_id",referencedColumnName = "id")
	List<Shop> shopList=new ArrayList<Shop>();
	
	public Broker() {
		super();
	}
	public Broker(Long id, String brokerFirstName, String brokerLastName, Long contact, String email) {
		super();
		this.id = id;
		this.brokerFirstName = brokerFirstName;
		this.brokerLastName = brokerLastName;
		this.contact = contact;
		this.email = email;
	}
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public void setBrokerFirstName(String brokerFirstName) {
		this.brokerFirstName = brokerFirstName;
	}
	

	public String getBrokerFirstName() {
		return brokerFirstName;
	}
	public String getBrokerLastName() {
		return brokerLastName;
	}

	public void setBrokerLastName(String brokerLastName) {
		this.brokerLastName = brokerLastName;
	}

	
		public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getBrokerAddress() {
		return brokerAddress;
	}
	public void setBrokerAddress(Address brokerAddress) {
		this.brokerAddress = brokerAddress;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	

	public List<Flat> getFlatList() {
		return flatList;
	}
	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}
	public List<Plot> getPlotList() {
		return plotList;
	}
	public void setPlotList(List<Plot> plotList) {
		this.plotList = plotList;
	}
	public List<Shop> getShopList() {
		return shopList;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	@Override
	public String toString() {
		return "Broker [id=" + id + ", brokerFirstName=" + brokerFirstName + ", brokerLastName=" + brokerLastName
				+ ", contact=" + contact + ", email=" + email + "]";
	}


	
	
	
	


}
