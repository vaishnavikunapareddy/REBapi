package com.cg.rebapi.model;

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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="owner")
	

public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	private Long id;
	@NotNull
	@Size(min = 3, message = "owner first name should have atleast 3 character")

	private String firstName;
	
	@NotNull
	@Size(min = 3, message = "owner last name should have atleast 3 character")

	private String lastName;

	@NotNull	
	private Long contact;

	@NotNull	
	private String email;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address ownerAddress;
	@OneToMany(mappedBy="owner")
	List<Customer> customerLisr=new ArrayList<Customer>();
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	List<Flat> flatList=new ArrayList<Flat>();
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	List<Plot> plotList=new ArrayList<Plot>();
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	List<Shop> shopList=new ArrayList<Shop>();
	

	public Owner() {
		super();
	}
	public Owner(Long id, String firstName, String lastName, Long contact, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
	}
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
	
	
	
	public Address getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(Address ownerAddress) {
		this.ownerAddress = ownerAddress;
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
	
	public List<Customer> getCustomerLisr() {
		return customerLisr;
	}
	public void setCustomerLisr(List<Customer> customerLisr) {
		this.customerLisr = customerLisr;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ ", email=" + email + "]";
	}
		
		
}