package com.poc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.poc.app.entity.Cities;



@Repository
public interface CitiesRepo extends JpaRepository<Cities,Integer> {
	Cities findByCity(String city);

	List<Cities> findByCountry(String country);

}
