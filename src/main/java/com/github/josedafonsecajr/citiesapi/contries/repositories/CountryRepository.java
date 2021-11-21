package com.github.josedafonsecajr.citiesapi.contries.repositories;

import com.github.josedafonsecajr.citiesapi.contries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
