package sk.datalan.datalanproject.data.city;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.datalan.datalanproject.data.city.bodies.CityRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String name;

    public City(CityRequest cityRequest) {
        this.code = cityRequest.getCode();
        this.name = cityRequest.getName();
    }
}
