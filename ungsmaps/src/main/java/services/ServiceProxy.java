package services;

import model.*;
import java.util.List;

public class ServiceProxy implements Service {

    private LocationConnector delegate;

    public ServiceProxy(LocationFactory locationFactory) {
        this.delegate = locationFactory.buildCompositeConnector();
    }

    public List<Coordinate> getRoad(LocationSearchDto locationSearchDto) {
        return this.delegate.getData(locationSearchDto.getArrival(), locationSearchDto.getDeparture());
    }

}