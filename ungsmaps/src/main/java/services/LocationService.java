package services;

import circuitBreaker.ICircuitBreaker;
import model.*;
import java.util.List;

public class LocationService implements Service {

    private ICircuitBreaker circuitBreaker;

    public LocationService(ICircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    public List<Coordinate> getRoad(LocationSearchDto locationSearchDto) {
        return this.circuitBreaker.doSomething(locationSearchDto.getArrival(), locationSearchDto.getDeparture());
    }

}