package sk.datalan.datalanproject.data.addess.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.state.State;

@Getter
@Setter
public class AddressResponse {
    private int id;
    private String street;
    private String zip;
    private City city;
    private State state;



    public AddressResponse(Address address){
        this.id = address.getId();
        this.street = address.getStreet();
        this.zip = address.getZip();
        this.city = address.getCity();
        this.state = address.getState();
    }
}
