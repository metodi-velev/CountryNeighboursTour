package com.countryneighbourstour.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.countryneighbourstour.demo.model.Country;
import com.countryneighbourstour.demo.model.dto.CountryDTO;
import com.countryneighbourstour.demo.model.dto.ResultDTO;
import com.countryneighbourstour.demo.service.CountryService;

@Controller
@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResultDTO restMethod(@RequestParam("start") String start,
			@RequestParam("budgetPerCountry") Double budgetPerCountry, @RequestParam("totalBudget") Double totalBudget,
			@RequestParam("currency") String currency,
			@RequestParam(name = "exchangeRate", required = false) Double exchangeRate) {
		return countryService.calculate(start, budgetPerCountry, totalBudget, currency, exchangeRate);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Country savePost(@RequestBody CountryDTO countryDTO) {
		return countryService.saveCountry(countryDTO);
	}

	@GetMapping(value = "/{id}/neighbours/{neighbourId}")
	@ResponseStatus(HttpStatus.OK)
	public Country addNeighbourCountry(@PathVariable Long id, @PathVariable Long neighbourId) {
		return countryService.addNeighbour(id, neighbourId);
	}

	@GetMapping(value = "/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Country> getAll() {
		return countryService.getAllCountries();
	}
}
