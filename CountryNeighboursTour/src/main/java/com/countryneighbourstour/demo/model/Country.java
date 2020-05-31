package com.countryneighbourstour.demo.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "country")
public class Country implements Comparable<Country> {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	@JsonBackReference
	private Country parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<Country> neighbours = new TreeSet<>();

	private static Double budget;

	private Double amountInCountryCurrency;

	private Double exchangeRate;

	private String currency;

	public Country() {
	}

	public Country(String name, String currency, Double exchangeRate) {
		this.name = name;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getParent() {
		return parent;
	}

	public void setParent(Country parent) {
		this.parent = parent;
	}

	public Set<Country> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Set<Country> neighbours) {
		this.neighbours = neighbours;
	}

	public static Double getBudget() {
		return budget;
	}

	public static void setBudget(Double budget) {
		Country.budget = budget;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmountInCountryCurrency() {
		return amountInCountryCurrency;
	}

	public void setAmountInCountryCurrency(Double amountInCountryCurrency) {
		this.amountInCountryCurrency = amountInCountryCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public void addNeighbour(Country country) {
		this.neighbours.add(country);
	}

	@Override
	public int compareTo(Country c) {
		return c.getName().compareTo(this.getName());
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", startCountry=" + parent + ", neighbours=" + neighbours + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
