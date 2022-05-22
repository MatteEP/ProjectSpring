package sk.datalan.datalanproject.logic.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.city.CityRepository;
import sk.datalan.datalanproject.data.city.bodies.CityRequest;

import java.util.List;

@Service
public class CityService implements CityServiceInterface {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addCity(CityRequest cityRequest) {
        return cityRepository.saveAndFlush(new City(cityRequest));
    }


}
