package circuitBreaker;

import model.Coordinate;
import model.LocationConnector;

public class HalfOpenCircuitState implements CircuitState {

    private LocationConnector connectorToTesting;
    private Coordinate from, to;

    @Override
    public void call(LocationConnector connector) {
        // Do nothing
    }

    @Override
    public CircuitState nextState() {
        try {
            connectorToTesting.getData(null);
            return new CloseCircuiteState();
        } catch (RuntimeException e) {
            return new OpenCircuitState();
        }
    }

}