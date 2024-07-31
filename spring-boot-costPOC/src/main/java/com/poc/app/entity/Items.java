package com.poc.app.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Items {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int item_id;
	private String category;
	private int cpi_factor;
	private String name;
	private int rent_factor;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy="imp")//, cascade = CascadeType.ALL
	private List<Prices> price1;
	
	
	public List<Prices> getPrice1() {
		return price1;
	}
	public void setPrice1(List<Prices> price1) {
		this.price1 = price1;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCpi_factor() {
		return cpi_factor;
	}
	public void setCpi_factor(int cpi_factor) {
		this.cpi_factor = cpi_factor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRent_factor() {
		return rent_factor;
	}
	public void setRent_factor(int rent_factor) {
		this.rent_factor = rent_factor;
	}

}
