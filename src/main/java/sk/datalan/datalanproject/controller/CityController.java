package sk.datalan.datalanproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.datalan.datalanproject.data.city.bodies.CityRequest;
import sk.datalan.datalanproject.data.city.bodies.CityResponse;
import sk.datalan.datalanproject.logic.city.CityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> addCity(@RequestBody CityRequest cityRequest) {
        return new ResponseEntity<>(new CityResponse(cityService.addCity(cityRequest)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAllCities() {
        return cityService.findAllCities().stream().map(CityResponse::new).collect(Collectors.toList());
    }

}