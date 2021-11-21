package com.github.josedafonsecajr.citiesapi.distances.service;


import com.github.josedafonsecajr.citiesapi.distances.DistanceService;
import com.github.josedafonsecajr.citiesapi.swagger.IDistanceResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/distances")
public class DistanceResource implements IDistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cityFrom,
                                   @RequestParam(name = "to") final Long cityTo) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMilles(cityFrom, cityTo));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cityFrom,
                         @RequestParam(name = "to") final Long cityTo) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(cityFrom, cityTo));
    }

}
