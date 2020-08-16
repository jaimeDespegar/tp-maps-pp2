package factory;

import core.ICircuitBreaker;
import core.*;
import services.LocationService;

public class LocationServiceFactory implements ServiceFactory {

    @Override
    public Service build(ICircuitBreaker circuitBreaker) {
        return new LocationService(circuitBreaker);
    }

}