package com.github.josedafonsecajr.citiesapi.contries.resources;

import com.github.josedafonsecajr.citiesapi.contries.entities.Country;
import com.github.josedafonsecajr.citiesapi.contries.repositories.CountryRepository;
import com.github.josedafonsecajr.citiesapi.swagger.ICountryResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource implements ICountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);

        return optional.map(country -> ResponseEntity.ok().body(country)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
