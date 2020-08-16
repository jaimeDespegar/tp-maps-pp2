package core;

import model.LocationConnector;

public interface CircuitFactory {

    ICircuitBreaker build(LocationConnector connector);

}