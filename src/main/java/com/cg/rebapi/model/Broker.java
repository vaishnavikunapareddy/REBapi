package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="broker")
public class Broker {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer brokerId;
	@Column(name="bname")
	private String brokerName;
	@Column(name="phone")
	private Long contact;
	@Column(name="email")
	private String email;
	@Column(name="city")
	private String city;
	public Broker() {
		super();
	}
	public Broker(Integer brokerId, String brokerName, Long contact, String email, String city) {
		super();
		this.brokerId = brokerId;
		this.brokerName = brokerName;
		this.contact = contact;
		this.email = email;
		this.city = city;
	}
	public Integer getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Broker [brokerId=" + brokerId + ", brokerName=" + brokerName + ", contact=" + contact + ", email="
				+ email + ", city=" + city + "]";
	}
	
	


}
