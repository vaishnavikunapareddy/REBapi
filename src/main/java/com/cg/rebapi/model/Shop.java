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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shop")
public class Shop {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long shopId;
	@NotNull
	private String shopName;
	@NotNull
	private Integer noOfRooms;
	@NotNull
	private Integer squareFeet;
	@NotNull
	private Integer price;
	@NotNull
	private String status;
	public Shop() {
		super();
	}
	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name="aid")
//	Address address;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address shopAddress;
	
	
	public Shop(Long shopId, @NotNull String shopName, @NotNull Integer noOfRooms, @NotNull Integer squareFeet,
			@NotNull Integer price, @NotNull String status) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.noOfRooms = noOfRooms;
		this.squareFeet = squareFeet;
		this.price = price;
		this.status = status;
	}

	
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Integer getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public Integer getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(Integer squareFeet) {
		this.squareFeet = squareFeet;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String availability) {
		this.status = availability;
	}
	
	public Address getShopAddress() {
		return shopAddress;
	}


	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}


	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", noOfRooms=" + noOfRooms + ", squareFeet="
				+ squareFeet + ", price=" + price + ", status=" + status + "]";
	}
    
}