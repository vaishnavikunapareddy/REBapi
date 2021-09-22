package com.cg.rebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Flat;


@Repository
public interface FlatRepository extends JpaRepository<Flat, Long>{
	
	@Query("select f from Flat f where f.status like :p1")
	public List<Flat> getFlatStatus(@Param("p1") String p1 );
	

}
