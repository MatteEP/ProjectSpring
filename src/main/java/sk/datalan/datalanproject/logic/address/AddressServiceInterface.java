package sk.datalan.datalanproject.logic.address;

import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.addess.bodies.AddressRequest;

import java.util.List;

public interface AddressServiceInterface {

    Address addAddress(AddressRequest address);

    List<Address> findAllAddresses();
}
