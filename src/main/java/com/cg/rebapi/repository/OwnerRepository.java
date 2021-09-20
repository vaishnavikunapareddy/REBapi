package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.rebapi.model.Owner;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
