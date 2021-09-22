package com.cg.rebapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Size(min=3, message = "flat name should have minimum 3 characters")
	@NotNull
	private String flatName;
	@NotNull
	private Integer price;
	@NotNull
	
	private String type;
	@NotNull
	private String squareFeet;
	@NotNull
	private String status;
	
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address flatAddress;
	
	public Flat() {
		super();
	}
	
	

	public Flat(Long id,
			@Size(min = 3, message = "flat name should have minimum 3 characters") @NotNull String flatName,
			@NotNull Integer price, @NotNull String type, @NotNull String squareFeet, @NotNull String status) {
		super();
		this.id = id;
		this.flatName = flatName;
		this.price = price;
		this.type = type;
		this.squareFeet = squareFeet;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlatName() {
		return flatName;
	}
	public void setFlatName(String flatName) {
		this.flatName = flatName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(Address flatAddress) {
		this.flatAddress = flatAddress;
	}

	@Override
	public String toString() {
		return "Flat [id=" + id + ", flatName=" + flatName + ", price=" + price + ", type=" + type + ", squareFeet="
				+ squareFeet + ", status=" + status + "]";
	}



	
	
}
