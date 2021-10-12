package com.cg.rebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rebapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
