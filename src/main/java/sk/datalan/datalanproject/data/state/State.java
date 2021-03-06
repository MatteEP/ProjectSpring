package sk.datalan.datalanproject.data.state;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.datalan.datalanproject.data.state.bodies.StateRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;
    private String name;

    public State(StateRequest stateRequest) {
        this.code = stateRequest.getCode();
        this.name = stateRequest.getName();
    }
}
