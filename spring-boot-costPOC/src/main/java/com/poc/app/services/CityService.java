package com.poc.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.app.entity.Cities;
import com.poc.app.entity.Exchange_rates;
import com.poc.app.entity.Items;
import com.poc.app.entity.Prices;
import com.poc.app.repository.CitiesRepo;
import com.poc.app.repository.Exchange_ratesRepo;
import com.poc.app.repository.ItemsRepo;
import com.poc.app.repository.PricesRepo;

@Service
public class CityService {
	@Autowired
	CitiesRepo crepo;

	@Autowired
	ItemsRepo irepo;
	
	@Autowired
	Exchange_ratesRepo errepo;
	
	@Autowired
	PricesRepo prepo;
	
	public ResponseEntity<?> getAllCities() {
		List<Cities> list=crepo.findAll();
		return new ResponseEntity<List<Cities>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getPrice_items() {
		List<Items> list=irepo.findAll();
		return new ResponseEntity<List<Items>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getExchange_rates() {
		List<Exchange_rates> list=errepo.findAll();
		return new ResponseEntity<List<Exchange_rates>>(list, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getCity_prices() {
		List<Prices> list=prepo.findAll();
		return new ResponseEntity<List<Prices>>(list, HttpStatus.OK);
	}

	public List<Prices> searchPricesByCity(String cname) {
		List<Cities> list = crepo.findAll();
		int id = 0;
		for (Cities c : list) {
			if (c.getCity().equalsIgnoreCase(cname)) {
				id = c.getCity_id();
				break;
			}
		}

		return prepo.findBycid(id);
	
	}

	public ResponseEntity<?> savePrice(Prices price) {
		
		Optional<Cities> city = crepo.findById(price.getCid());
		Optional<Items> item1=irepo.findById(price.getIid());
		
		if (city.isPresent())
		{
			price.setCmp(city.get());
		}
		System.out.println(item1);
		if(item1.isPresent())	
			price.setImp(item1.get());
		return new ResponseEntity<>(prepo.save(price), HttpStatus.CREATED);
	}


	public List<Prices> searchPricesByCityCategory(String cname, String category) {
		List<Cities> list = crepo.findAll();
		List<Items> item1= irepo.findAll();
		List<Integer> ids = new ArrayList<>();
		
		int id = 0;
		for (Cities c : list) {
			if (c.getCity().equalsIgnoreCase(cname)) {
				id = c.getCity_id();
				break;
			}
		}
		int id1=0;
		for (Items i : item1) {
			if (i.getCategory().equalsIgnoreCase(category)) {
				id1 = i.getItem_id();
				ids.add(id1);
			}
		}
		return prepo.findBycidAndIidIn(id,ids);

	}
    
	//get all cities by country name 
	public List<Cities> getCitiesByCountry(String country) {
		return crepo.findByCountry(country);
	}

	//get city detail by name of city
	public Cities getCityByname(String city) {
		// TODO Auto-generated method stub
		return crepo.findByCity(city);
	}

	


	
}
