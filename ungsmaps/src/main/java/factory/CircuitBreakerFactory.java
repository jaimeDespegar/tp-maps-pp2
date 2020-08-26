package factory;

import core.ICircuitBreaker;
import core.CircuitFactory;
import model.Location;
import circuitBreaker.CircuitBreaker;
import circuitBreaker.states.CloseCircuiteState;

public class CircuitBreakerFactory implements CircuitFactory {

    @Override
    public ICircuitBreaker build(Location connector) {
        return new CircuitBreaker(connector, new CloseCircuiteState());
    }

}