package factory;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.ICircuitBreaker;
import core.*;
import model.LocationConnector;
import services.LocationService;

public class LocationServiceFactory implements ServiceFactory {

    @Override
    public Service build(LocationConnector provider) {
        ICircuitBreaker circuitBreaker = new CircuitBreaker(provider);
        return new LocationService(circuitBreaker);
    }

}