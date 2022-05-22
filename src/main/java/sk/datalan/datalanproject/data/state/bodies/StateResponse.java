package sk.datalan.datalanproject.data.state.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.datalan.datalanproject.data.state.State;

@Getter
@Setter
public class StateResponse {
    private String code;
    private String name;

    public StateResponse(State state) {
        this.code = state.getCode();
        this.name = state.getName();
    }
}
