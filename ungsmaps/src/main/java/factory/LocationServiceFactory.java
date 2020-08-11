package factory;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.ICircuitBreaker;
import core.*;
import model.LocationConnector;
import services.LocationService;

public class LocationServiceFactory implements ServiceFactory {

    private ClassFactory classFactory;

    public LocationServiceFactory(ClassFactory classFactory) {
        this.classFactory = classFactory;
    }

    @Override
    public Service build() {
        ICircuitBreaker circuitBreaker = new CircuitBreaker((LocationConnector) this.classFactory.buildClass());
        return new LocationService(circuitBreaker);
    }

}