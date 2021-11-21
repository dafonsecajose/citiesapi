package com.github.josedafonsecajr.citiesapi.distances;

import com.github.josedafonsecajr.citiesapi.cities.entities.City;
import com.github.josedafonsecajr.citiesapi.cities.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * @param cityFrom
     * @param cityTo
     * @return
     */
    public Double distanceByPointsInMilles(final Long cityFrom, final Long cityTo) {
        log.info("nativePostgresMiles({}, {})", cityFrom, cityTo);
        return cityRepository.distanceByPoints(cityFrom, cityTo);
    }


    /**
     * @param cityFrom
     * @param cityTo
     * @return
     */

    public Double distanceByCubeInMeters(final Long cityFrom, final Long cityTo) {
        log.info("distanceByCubeInMeters({}, {})", cityFrom, cityTo);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(cityFrom, cityTo)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
