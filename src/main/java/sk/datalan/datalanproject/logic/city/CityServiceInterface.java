package sk.datalan.datalanproject.logic.city;

import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.city.bodies.CityRequest;

import java.util.List;

public interface CityServiceInterface {

    List<City> findAllCities();

    City addCity(CityRequest city);
}
