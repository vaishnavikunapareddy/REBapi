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
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "plot")
public class Plot {
	@Id 
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	

	private Long plotId;
	@NotNull

	@Size(min=3, message = "plot name should have minimum 3 characters")
	private String plotName;
	@NotNull
	
	private String squareFeet;
	@NotNull
	private Integer price;
	@NotNull
   	private String status;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address plotAddress;
	public Plot() {
		super();
	}

	

	

	public Plot(Long plotId, @Size(min = 3, message = "plot name should have minimum 3 characters") String plotName,
			String squareFeet, Integer price, String status) {
		super();
		this.plotId = plotId;
		this.plotName = plotName;
		this.squareFeet = squareFeet;
		this.price = price;
		this.status = status;
	}

	public Long getPlotId() {
		return plotId;
	}

	public void setPlotId(Long plotId) {
		this.plotId = plotId;
	}

	public String getPlotName() {
		return plotName;
	}

	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

	public String getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(String squareFeet) {
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

	public void setStatus(String status) {
		this.status = status;
	}
	






	public Address getPlotAddress() {
		return plotAddress;
	}





	public void setPlotAddress(Address plotAddress) {
		this.plotAddress = plotAddress;
	}





	@Override
	public String toString() {
		return "Plot [plotId=" + plotId + ", plotName=" + plotName + ", squareFeet=" + squareFeet + ", price=" + price
				+ ", status=" + status + "]";
	}
	
	
	
	
}