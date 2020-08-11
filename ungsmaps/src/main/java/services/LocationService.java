package services;

import circuitBreaker.ICircuitBreaker;
import core.Service;
import model.Coordinate;
import java.util.List;

public class LocationService implements Service {

    private ICircuitBreaker circuitBreaker;

    public LocationService(ICircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    public List<Coordinate> getRoad(Coordinate arrival, Coordinate departure) {
        return this.circuitBreaker.doSomething(arrival, departure);
    }

}