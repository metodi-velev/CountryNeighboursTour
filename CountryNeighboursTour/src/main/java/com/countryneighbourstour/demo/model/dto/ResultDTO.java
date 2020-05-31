package com.countryneighbourstour.demo.model.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.countryneighbourstour.demo.model.Country;

public class ResultDTO {
	private Set<String> neighbours;
	private Integer numNeighbours;
	private Integer roundtrips;
	private Double leftover;
	private Map<String, Double> budgetPerCountry;

	public ResultDTO() {
	}

	public ResultDTO(Set<String> neighbours, Integer numNeighbours, Integer roundtrips, Double leftover) {
		this.neighbours = neighbours;
		this.numNeighbours = numNeighbours;
		this.roundtrips = roundtrips;
		this.leftover = leftover;
	}

	public ResultDTO(Set<String> neighbours, Integer numNeighbours, Integer roundtrips, Double leftover,
			Map<String, Double> budgetPerCountry) {
		this.neighbours = neighbours;
		this.numNeighbours = numNeighbours;
		this.roundtrips = roundtrips;
		this.leftover = leftover;
		this.budgetPerCountry = budgetPerCountry;
	}

	public Integer getNumNeighbours() {
		return numNeighbours;
	}

	public ResultDTO setNumNeighbours(Integer numNeighbours) {
		this.numNeighbours = numNeighbours;
		return this;
	}

	public Set<String> getNeighbours() {
		return neighbours;
	}

	public ResultDTO setNeighbours(Set<String> neighbours) {
		this.neighbours = neighbours;
		return this;
	}

	public Integer getRoundtrips() {
		return roundtrips;
	}

	public ResultDTO setRoundtrips(Integer roundtrips) {
		this.roundtrips = roundtrips;
		return this;
	}

	public Double getLeftover() {
		return leftover;
	}

	public ResultDTO setLeftover(Double leftover) {
		this.leftover = leftover;
		return this;
	}

	public Map<String, Double> getBudgetPerCountry() {
		return budgetPerCountry;
	}

	public ResultDTO setBudgetPerCountry(Map<String, Double> budgetPerCountry) {
		this.budgetPerCountry = budgetPerCountry;
		return this;
	}
}
