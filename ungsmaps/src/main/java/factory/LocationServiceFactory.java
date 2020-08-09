package factory;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.ICircuitBreaker;
import model.ProviderFactory;
import model.Service;
import model.ServiceFactory;
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