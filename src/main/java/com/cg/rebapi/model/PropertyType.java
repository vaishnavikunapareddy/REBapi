package com.cg.rebapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name= "proType")
public class PropertyType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
//	
////	@OneToMany
////	@JoinColumn(name="broker_id",referencedColumnName = "id")
////	List<Flat> flatList=new ArrayList<Flat>();
//	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="property_type_id", referencedColumnName = "id")
//	List<Flat> flatList=new ArrayList<Flat>();
//	
//	//mapping with plot
//		@OneToMany
//		@JoinColumn(name="broker_id",referencedColumnName = "id")
//		List<Plot> plotList=new ArrayList<Plot>();
//		
//		//mapping with shop
//		@OneToMany
//		@JoinColumn(name="broker_id",referencedColumnName = "id")
//		List<Shop> shopList=new ArrayList<Shop>();
//		
//		
//
//		public PropertyType() {
//			super();
//		}
//
//
//
//		public PropertyType(Long id, List<Flat> flatList, List<Plot> plotList, List<Shop> shopList) {
//			super();
//			this.id = id;
//			this.flatList = flatList;
//			this.plotList = plotList;
//			this.shopList = shopList;
//		}
//
//
//
//		public Long getId() {
//			return id;
//		}
//
//
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//
//
//		public List<Flat> getFlatList() {
//			return flatList;
//		}
//
//
//
//		public void setFlatList(List<Flat> flatList) {
//			this.flatList = flatList;
//		}
//
//
//
//		public List<Plot> getPlotList() {
//			return plotList;
//		}
//
//
//
//		public void setPlotList(List<Plot> plotList) {
//			this.plotList = plotList;
//		}
//
//
//
//		public List<Shop> getShopList() {
//			return shopList;
//		}
//
//
//
//		public void setShopList(List<Shop> shopList) {
//			this.shopList = shopList;
//		}
//
//
//
//		@Override
//		public String toString() {
//			return "PropertyType [id=" + id + ", flatList=" + flatList + ", plotList=" + plotList + ", shopList="
//					+ shopList + "]";
//		}
//		
//		
//		
//		
//	
	
	

}
