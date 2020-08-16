package factory;

import circuitBreaker.CircuitBreaker;
import core.ICircuitBreaker;
import circuitBreaker.states.CloseCircuiteState;
import core.CircuitFactory;
import model.LocationConnector;

public class CircuitBreakerFactory implements CircuitFactory {

    @Override
    public ICircuitBreaker build(LocationConnector connector) {
        return new CircuitBreaker(connector, new CloseCircuiteState());
    }

}