package circuitBreaker;

import model.LocationConnector;

public interface CircuitState {

    void call(LocationConnector connector);
    CircuitState nextState();

}