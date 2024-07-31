package com.poc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.app.entity.Items;






@Repository
public interface ItemsRepo extends JpaRepository<Items,Integer> {
	
}
