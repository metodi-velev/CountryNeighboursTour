package com.countryneighbourstour.demo.model.dto;

public class CountryDTO {

	private String name;
	private String currency;
	private Double exchangeRate;

	public CountryDTO() {
	}

	public CountryDTO(String name, String currency, Double exchangeRate) {
		this.name = name;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
