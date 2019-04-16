package services;

import model.*;
import java.util.List;

public class ServiceProxy implements LocationProxy {

    private LocationConnector locationConnector;

    public ServiceProxy(LocationFactory locationFactory) {
        this.locationConnector = locationFactory.buildCompositeConnector();
    }

    public List<Coordinate> getRoad(LocationSearchDto locationSearchDto) {
        return this.locationConnector.getData(locationSearchDto);
    }

}