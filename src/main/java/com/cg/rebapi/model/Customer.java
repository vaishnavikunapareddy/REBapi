package com.cg.rebapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="customer_tbl")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long customerId;
	@Column(name="lname", length = 20)
	@NotNull
	@Size(min=2, message="last name should contain minimum 2 characters")
	private  String customerLastName;
	@Column(name="fname", length = 20)
	@NotNull
	@Size(min=2, message="first name should contain minimum 2 characters")
	private String customerFirstName;
	@Column(name="phone")
	@NotNull
	private Long customerContact;
	@Email
	@NotNull
	@Column(name="email", length = 20)
	private String email;
//	@OneToOne
//	public Address customerAddress;
	public Customer() {
		super();
	}
	public Customer(Long customerId,
			@Size(min = 2, message = "last name should contain minimum 2 characters") String customerLastName,
			@Size(min = 2, message = "first name should contain minimum 2 characters") String customerFirstName,
			Long customerContact, @Email String email) {
		super();
		this.customerId = customerId;
		this.customerLastName = customerLastName;
		this.customerFirstName = customerFirstName;
		this.customerContact = customerContact;
		this.email = email;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerLastName=" + customerLastName + ", customerFirstName="
				+ customerFirstName + ", customerContact=" + customerContact + ", email=" + email + "]";
	}
	
	
}