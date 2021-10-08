package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Broker;
@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long>{
	


}
