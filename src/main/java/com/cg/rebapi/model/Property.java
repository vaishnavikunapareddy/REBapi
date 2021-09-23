package com.cg.rebapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
////	@OneToOne(fetch = FetchType.EAGER, optional = false)
////    @JoinColumn(name = "address_id")
////    private Address brokerAddress;
//	@OneToOne(fetch = FetchType.EAGER, optional=false)
//	@JoinColumn(name="propertyTypeId")
//	private PropertyType propertyType;
//	
//	
//
//	public Property() {
//		super();
//	}
//
//
//
//	public Property(Long id, PropertyType propertyType) {
//		super();
//		this.id = id;
//		this.propertyType = propertyType;
//	}
//
//
//
//	public Long getId() {
//		return id;
//	}
//
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//
//	public PropertyType getPropertyType() {
//		return propertyType;
//	}
//
//
//
//	public void setPropertyType(PropertyType propertyType) {
//		this.propertyType = propertyType;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Property [id=" + id + ", propertyType=" + propertyType + "]";
//	}
//	
//	
	
	

}
