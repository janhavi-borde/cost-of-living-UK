package com.poc.app.entity;


import java.util.List;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="cities")
public class Cities {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int city_id;
	private String country;
	private String city;
	private float latitude;
	private float longitude;
	private String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurency(String currency) {
		this.currency = currency;
	}
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy="cmp")//, cascade = CascadeType.ALL
	private List<Prices> price;
	
	public int getCity_id() {
		return city_id;
	}

	public List<Prices> getPrice() {
		return price;
	}

	public void setPrice(List<Prices> price) {
		this.price = price;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	
	
}
