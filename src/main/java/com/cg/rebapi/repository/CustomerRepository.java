package com.cg.rebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Customer;
import com.cg.rebapi.model.Flat;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	

}