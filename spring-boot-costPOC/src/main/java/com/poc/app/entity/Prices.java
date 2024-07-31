package com.poc.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name="prices")
public class Prices {
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int price_id;
	
	private String currency;
	
	private int iid;
	private float lowest_price;
	private float average_price;
	private float highest_price;
	private int cid;
	
	@ManyToOne(fetch = FetchType.EAGER)// cascasde = CascadeType.ALL,
	private Cities cmp;
	
	@ManyToOne(fetch = FetchType.EAGER)// cascasde = CascadeType.ALL,
	private Items imp;
	
	public int getPrice_id() {
		return price_id;
	}
	public Items getImp() {
		return imp;
	}
	public void setImp(Items imp) {
		this.imp = imp;
	}
	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public float getLowest_price() {
		return lowest_price;
	}
	public void setLowest_price(float lowest_price) {
		this.lowest_price = lowest_price;
	}
	public float getAverage_price() {
		return average_price;
	}
	public void setAverage_price(float average_price) {
		this.average_price = average_price;
	}
	public float getHighest_price() {
		return highest_price;
	}
	public void setHighest_price(float highest_price) {
		this.highest_price = highest_price;
	}
	public int getCid() {
		return cid;
	}
	public Cities getCmp() {
		return cmp;
	}
	public void setCmp(Cities cmp) {
		this.cmp = cmp;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
}
