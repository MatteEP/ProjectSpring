package sk.datalan.datalanproject.data.addess;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.datalan.datalanproject.data.addess.bodies.AddressRequest;
import sk.datalan.datalanproject.data.city.City;
import sk.datalan.datalanproject.data.state.State;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String zip;

    @ManyToOne(cascade=CascadeType.MERGE)
    private City city;

    @ManyToOne(cascade=CascadeType.MERGE)
    private State state;

    public Address(AddressRequest addressRequest) {
        this.id = addressRequest.getId();
        this.street = addressRequest.getStreet();
        this.zip = addressRequest.getZip();
        this.city = addressRequest.getCity();
        this.state = addressRequest.getState();
    }

}

