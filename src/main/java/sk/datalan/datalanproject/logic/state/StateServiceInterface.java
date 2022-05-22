package sk.datalan.datalanproject.logic.state;

import sk.datalan.datalanproject.data.state.State;
import sk.datalan.datalanproject.data.state.bodies.StateRequest;

import java.util.List;

public interface StateServiceInterface {

    List<State> findAllStates();

    State addState(StateRequest stateRequest);
}
