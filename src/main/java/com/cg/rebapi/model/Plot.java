package com.cg.rebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "plot_tbl")
public class Plot {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	private Long plotId;
	@NotNull
	@Column(name = "plotname" ,length = 20)
	@Size(min=3, message = "plot name should have minimum 3 characters")
	private String plotName;
	@NotNull
	@Column(name = "squareFeet")
	private String squareFeet;
	@NotNull
	@Column(name = "price")
	private Integer price;
	@NotNull
    @Column(name = "availability")
	private Boolean availability;
    
	public Plot() {
		super();
	}

	public Plot(Long plotId, @Size(min = 3, message = "plot name should have minimum 3 characters") String plotName,
			String squareFeet, Integer price, Boolean availability) {
		super();
		this.plotId = plotId;
		this.plotName = plotName;
		this.squareFeet = squareFeet;
		this.price = price;
		this.availability = availability;
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

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Plot [plotId=" + plotId + ", plotName=" + plotName + ", squareFeet=" + squareFeet + ", price=" + price
				+ ", availability=" + availability + "]";
	}
	
	
	
	
}