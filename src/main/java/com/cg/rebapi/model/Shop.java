package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	private Integer shopId;
	@Column(name = "shopname" ,length = 20)
	private String shopName;
	@Column(name = "noofRooms")
	private Integer noOfRooms;
	@Column(name = "squareFeet")
	private Integer squareFeet;
	@Column(name = "price")
	private Integer price;
    @Column(name = "availability")
	private String availability;
	public Shop() {
		super();
	}
	public Shop(Integer shopId, String shopName, Integer noOfRooms, Integer squareFeet, Integer price,
			String availability) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.noOfRooms = noOfRooms;
		this.squareFeet = squareFeet;
		this.price = price;
		this.availability = availability;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
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
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", noOfRooms=" + noOfRooms + ", squareFeet="
				+ squareFeet + ", price=" + price + ", availability=" + availability + "]";
	}
    
}