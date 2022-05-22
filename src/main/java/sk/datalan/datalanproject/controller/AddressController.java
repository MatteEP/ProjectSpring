package sk.datalan.datalanproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.datalan.datalanproject.data.addess.bodies.AddressRequest;
import sk.datalan.datalanproject.data.addess.bodies.AddressResponse;
import sk.datalan.datalanproject.logic.address.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@RequestBody AddressRequest addressRequest) {
        return new ResponseEntity<>(new AddressResponse(addressService.addAddress(addressRequest)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAllAddresses() {
        return addressService.findAllAddresses().stream().map(AddressResponse::new).collect(Collectors.toList());
    }

}