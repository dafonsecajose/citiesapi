package com.github.josedafonsecajr.citiesapi.states.repositories;

import com.github.josedafonsecajr.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
