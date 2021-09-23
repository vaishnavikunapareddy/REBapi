package com.cg.rebapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long id;
	@NotNull
	@Size(min=2, message="last name should contain minimum 2 characters")
	private  String customerLastName;
	
	@NotNull
	@Size(min=2, message="first name should contain minimum 2 characters")
	private String customerFirstName;

	@NotNull
	private Long customerContact;
	@Email
	@NotNull
	private String email;
	

	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address customerAddress;
	
	@OneToMany
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private List<Flat> flatList=new ArrayList<Flat>();
	
	@OneToMany
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private List<Plot> plotList=new ArrayList<Plot>();
	
	@OneToMany
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private List<Shop> shopList=new ArrayList<Shop>();
	
	
	
	
	public Customer() {
		super();
	}
	
	

	
	
	public Customer(Long id,
			@NotNull @Size(min = 2, message = "last name should contain minimum 2 characters") String customerLastName,
			@NotNull @Size(min = 2, message = "first name should contain minimum 2 characters") String customerFirstName,
			@NotNull Long customerContact, @Email @NotNull String email) {
		super();
		this.id = id;
		this.customerLastName = customerLastName;
		this.customerFirstName = customerFirstName;
		this.customerContact = customerContact;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}




	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public Long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(Long customerContact) {
		this.customerContact = customerContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

	public Address getCustomerAddress() {
		return customerAddress;
	}




	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
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
		return "Customer [id=" + id + ", customerLastName=" + customerLastName + ", customerFirstName="
				+ customerFirstName + ", customerContact=" + customerContact + ", email=" + email + "]";
	}
	
	
	
}