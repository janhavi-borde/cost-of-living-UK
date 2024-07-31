package com.poc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.app.entity.Cities;
import com.poc.app.entity.Prices;
import com.poc.app.services.CityService;


@RestController
@RequestMapping("/api")

public class CitiesController{
	
	@Autowired 
	CityService service;

	@GetMapping(path="/cities")
	public ResponseEntity<?> getAllCities() {
		return service.getAllCities(); 
	}
	
	@GetMapping(path="/city/{city}")
	public Cities getCityByname(@PathVariable String city) {
		return (Cities) service.getCityByname(city); 
	}
	@GetMapping(path="/{country}")
	public List<Cities> getCitiesByCountry(@PathVariable String country) {
		return service.getCitiesByCountry(country); 
	}
	@GetMapping(path="/price_items")
	public ResponseEntity<?> getPrice_items() {
		return service.getPrice_items(); 
	}
	
	@GetMapping(path="/currency_exchange_rates")
	public ResponseEntity<?> getExchange_rates() {
		return service.getExchange_rates(); 
	}
	
	@GetMapping(path="/city_prices")
	public ResponseEntity<?> getCity_prices() {
		return service.getCity_prices(); 
	}
	//Search prices assigned to a particular city
		@GetMapping("/city_prices/{cname}")
		public List <Prices> searchPricesByCity(@PathVariable String cname){
			return service.searchPricesByCity(cname);
		}
		
		//Add a new price to the database
		@PostMapping("/save/price")
		public ResponseEntity<?> savePrice(@RequestBody Prices price) {
			return service.savePrice(price);
		}
		
	//search by city name and category
	@GetMapping("/city_prices/{cname}/{category}")
	public List <Prices> searchPricesByCityCategory(@PathVariable("cname") String cname,@PathVariable("category") String category){
		return service.searchPricesByCityCategory(cname,category);
		}
}
