package sk.datalan.datalanproject.logic.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.datalan.datalanproject.data.state.State;
import sk.datalan.datalanproject.data.state.StateRepository;
import sk.datalan.datalanproject.data.state.bodies.StateRequest;

import java.util.List;

@Service
@Transactional
public class StateService implements StateServiceInterface {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> findAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public State addState(StateRequest stateRequest) {
        return stateRepository.saveAndFlush(new State(stateRequest));
    }
}
