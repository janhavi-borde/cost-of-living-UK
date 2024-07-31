package com.poc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.poc.app.entity.Prices;

public interface PricesRepo extends JpaRepository<Prices,Integer> , CrudRepository<Prices, Integer>{
	public List<Prices> findBycid(int city_id);
	//find prices where cid=id and iid=id2/category=)
	public List<Prices> findBycidAndIidIn(int id, List<Integer> ids);
	
}