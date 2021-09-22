package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.rebapi.model.PropertyType;
@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long>{

}
