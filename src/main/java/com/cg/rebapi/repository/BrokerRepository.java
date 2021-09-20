package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.rebapi.model.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Long>{
	
	

}
