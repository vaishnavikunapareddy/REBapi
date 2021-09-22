package com.cg.rebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Plot;
import com.cg.rebapi.model.Shop;
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	
	@Query("select s from Shop s where s.status like :p1")
	public List<Shop> getShopStatus(@Param("p1") String p1 );

}
