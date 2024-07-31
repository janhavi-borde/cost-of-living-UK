package com.poc.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="excahnge_rates")
public class Exchange_rates {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private String currency;
		private float one_usd_to_currency;
		private float one_eur_to_currency;
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public float getOne_usd_to_currency() {
			return one_usd_to_currency;
		}
		public void setOne_usd_to_currency(float one_usd_to_currency) {
			this.one_usd_to_currency = one_usd_to_currency;
		}
		public float getOne_eur_to_currency() {
			return one_eur_to_currency;
		}
		public void setOne_eur_to_currency(float one_eur_to_currency) {
			this.one_eur_to_currency = one_eur_to_currency;
		}
		
}
