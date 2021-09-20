package com.cg.rebapi.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Flat {
	@Id
	private Long id;
	@Size(min=3, message = "flat name should have minimum 3 characters")
	@NotNull
	private String flatName;
	@NotNull
	private Integer price;
	@NotNull
	
	private Integer type;
	@NotNull
	private String squareFeet;
	@NotNull
	private Boolean availability;
	public Flat() {
		super();
	}
	public Flat(Long id,
			@Size(min = 3, message = "flat name should have minimum 3 characters") @NotNull String flatName,
			@NotNull Integer price, @NotNull Integer type, @NotNull String squareFeet, @NotNull Boolean availability) {
		super();
		this.id = id;
		this.flatName = flatName;
		this.price = price;
		this.type = type;
		this.squareFeet = squareFeet;
		this.availability = availability;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(String squareFeet) {
		this.squareFeet = squareFeet;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Flat [id=" + id + ", flatName=" + flatName + ", price=" + price + ", type=" + type + ", squareFeet="
				+ squareFeet + ", availability=" + availability + "]";
	}
	
	
}
