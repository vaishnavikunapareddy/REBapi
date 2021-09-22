package com.cg.rebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.rebapi.model.Flat;
import com.cg.rebapi.model.Plot;

public interface PlotRepository extends JpaRepository<Plot, Long>{
	
	@Query("select p from Plot p where p.status like :p1")
	public List<Plot> getPlotStatus(@Param("p1") String p1 );

}
