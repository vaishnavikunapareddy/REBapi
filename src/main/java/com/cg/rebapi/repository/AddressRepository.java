package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
	
}