package sk.datalan.datalanproject.logic.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.datalan.datalanproject.data.addess.Address;
import sk.datalan.datalanproject.data.addess.AddressRepository;
import sk.datalan.datalanproject.data.addess.bodies.AddressRequest;

import java.util.List;

@Service
@Transactional
public class AddressService implements AddressServiceInterface{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address addAddress(AddressRequest addressRequest) {
        return addressRepository.saveAndFlush(new Address(addressRequest));
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }
}

