package sk.datalan.datalanproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.datalan.datalanproject.data.state.bodies.StateRequest;
import sk.datalan.datalanproject.data.state.bodies.StateResponse;
import sk.datalan.datalanproject.logic.state.StateService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public ResponseEntity<StateResponse> addState(@RequestBody StateRequest stateRequest) {
        return new ResponseEntity<>(new StateResponse(stateService.addState(stateRequest)), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAllEmployees() {
        return stateService.findAllStates().stream().map(StateResponse::new).collect(Collectors.toList());
    }

}