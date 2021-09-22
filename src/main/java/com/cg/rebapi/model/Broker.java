package com.cg.rebapi.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address brokerAddress;

	
	
	
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
	@Override
	public String toString() {
		return "Broker [id=" + id + ", brokerFirstName=" + brokerFirstName + ", brokerLastName=" + brokerLastName
				+ ", contact=" + contact + ", email=" + email + "]";
	}


	
	
	
	


}
