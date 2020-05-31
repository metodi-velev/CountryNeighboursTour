package com.countryneighbourstour.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countryneighbourstour.demo.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
	Optional<Country> findByName(String name);
}
