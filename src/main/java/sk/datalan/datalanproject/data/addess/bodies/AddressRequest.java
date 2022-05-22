package sk.datalan.datalanproject.data.addess.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.state.State;

@Getter
@Setter
public class AddressRequest {
    private int id;
    private String street;
    private String zip;
    private City city;
    private State state;

}