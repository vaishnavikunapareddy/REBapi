package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.Flat;


@Repository
public interface FlatRepository extends JpaRepository<Flat, Long>{

}
