package com.cg.rebapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

}
