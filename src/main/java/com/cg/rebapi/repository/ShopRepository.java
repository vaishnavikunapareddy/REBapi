package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
