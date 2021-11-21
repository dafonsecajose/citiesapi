package com.github.josedafonsecajr.citiesapi.states.resources;

import com.github.josedafonsecajr.citiesapi.states.entities.State;
import com.github.josedafonsecajr.citiesapi.states.repositories.StateRepository;
import com.github.josedafonsecajr.citiesapi.swagger.IStateResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource implements IStateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }
}
