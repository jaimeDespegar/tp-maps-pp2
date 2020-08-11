package factory;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.ICircuitBreaker;
import core.*;
import services.LocationService;

public class LocationServiceFactory implements ServiceFactory {

    private ProviderFactory providerFactory;

    public LocationServiceFactory(ProviderFactory providerFactory) {
        this.providerFactory = providerFactory;
    }

    @Override
    public Service build() {
        ICircuitBreaker circuitBreaker = new CircuitBreaker(this.providerFactory.buildProvider());
        return new LocationService(circuitBreaker);
    }

}