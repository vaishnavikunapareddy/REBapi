package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

}
