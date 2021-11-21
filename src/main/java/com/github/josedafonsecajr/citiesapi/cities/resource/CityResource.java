package com.github.josedafonsecajr.citiesapi.cities.resource;

import com.github.josedafonsecajr.citiesapi.cities.entities.City;
import com.github.josedafonsecajr.citiesapi.cities.repositories.CityRepository;
import com.github.josedafonsecajr.citiesapi.swagger.ICityResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource implements ICityResource {

    private final CityRepository repository;

    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @PostMapping(value = "/find")
    public ResponseEntity<City> cityByName(@RequestBody Map<String, String> name) {
        Optional<City> optional = Optional.ofNullable(repository.findByName(name.get("name")));
        return optional.map(city -> ResponseEntity.ok().body(city)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
