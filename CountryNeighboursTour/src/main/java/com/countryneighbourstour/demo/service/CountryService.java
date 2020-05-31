package com.countryneighbourstour.demo.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.countryneighbourstour.demo.model.Country;
import com.countryneighbourstour.demo.model.dto.CountryDTO;
import com.countryneighbourstour.demo.model.dto.ResultDTO;
import com.countryneighbourstour.demo.repository.CountryRepository;

@Transactional
@Service
public class CountryService {

	private String start;
	private Double budgetPerCountry;
	private Double totalBudget;
	private String currency;
	private Double exchangeRate;
	private Integer numNeighbours;
	private Set<String> neighbourNames;
	private Double leftover;
	private Integer roundtrips;
	private ResultDTO resultDTO = new ResultDTO();

	@Autowired
	private CountryRepository countryRepository;

	public ResultDTO calculate(String start, Double budgetPerCountry, Double totalBudget, String currency,
			Double exchangeRate) {
		initializeMembers(start, budgetPerCountry, totalBudget, currency, exchangeRate);
		Country country = countryRepository.findByName(start).orElse(null);

		calculateNumNeighbours(country);
		calculateRoundtrips();
		calculateLeftover();
		calculateBudgetInCountryCurrency(country);
		setNeighbourNames(country);

		return resultDTO;
	}

	private void initializeMembers(String start, Double budgetPerCountry, Double totalBudget, String currency,
			Double exchangeRate) {
		this.start = start;
		this.budgetPerCountry = budgetPerCountry;
		Country.setBudget(budgetPerCountry);
		this.totalBudget = totalBudget;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
	}

	private void calculateBudgetInCountryCurrency(Country country) {
		country.getNeighbours().stream().forEach(n -> {
			n.setAmountInCountryCurrency(Country.getBudget() * n.getExchangeRate());
		});
		resultDTO.setBudgetPerCountry(country.getNeighbours().stream()
				.collect(Collectors.toMap(Country::getName, Country::getAmountInCountryCurrency)));
	}

	private void setNeighbourNames(Country country) {
		neighbourNames = country.getNeighbours().stream().map(n -> n.getName()).collect(Collectors.toSet());
		resultDTO.setNeighbours(neighbourNames);
	}

	public Country saveCountry(CountryDTO countryDTO) {
		return countryRepository
				.save(new Country(countryDTO.getName(), countryDTO.getCurrency(), countryDTO.getExchangeRate()));
	}

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public Country addNeighbour(Long id, Long neighbourId) {
		Country country = isCountryPersisted(id);
		Country neighbour = isCountryPersisted(neighbourId);
		country.addNeighbour(neighbour);
		neighbour.setParent(country);
		return country;
	}

	public void calculateNumNeighbours(Country country) {
		numNeighbours = country.getNeighbours().size();
		resultDTO.setNumNeighbours(numNeighbours);
	}

	public void calculateRoundtrips() {
		Double numNeighboursDouble = Double.valueOf(numNeighbours);
		Double result = totalBudget / (numNeighboursDouble * budgetPerCountry);
		roundtrips = result.intValue();
		resultDTO.setRoundtrips(roundtrips);
	}

	public void calculateLeftover() {
		leftover = totalBudget - (roundtrips * numNeighbours * budgetPerCountry);
		resultDTO.setLeftover(leftover);
	}

	public Country isCountryPersisted(Long id) {
		Country country = countryRepository.findById(id).orElse(null);
		if (country == null)
			throw new RuntimeException("Country with name " + id + " does not exist.");
		return country;
	}

}
