package sk.datalan.datalanproject.data.city.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.datalan.datalanproject.data.city.City;

@Getter
@Setter
public class CityResponse {
    private String code;
    private String name;

    public CityResponse(City city) {
        this.code = city.getCode();
        this.name = city.getName();
    }
}