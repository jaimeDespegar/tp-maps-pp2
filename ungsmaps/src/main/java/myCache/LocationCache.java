package myCache;

import model.Coordinate;
import model.DataCache;
import model.LocationConnector;
import model.LocationSearchDto;
import java.util.List;

public class LocationCache implements LocationConnector {

    private DataCache dataCache;
    private LocationConnector locationConnectorToNext;

    public LocationCache(LocationConnector locationConnectorToNext, DataCache dataCache) {
        this.dataCache = dataCache;
        this.locationConnectorToNext = locationConnectorToNext;
    }

    public Boolean isAvailable() {
        return Boolean.TRUE;
    }

    public Boolean on() {
        return true;
    }

    public Boolean off() {
        return true;
    }

    public List<Coordinate> getData(LocationSearchDto locationSearchDto) {

        List<Coordinate> result = this.dataCache.getRoadByCoordinates(locationSearchDto);
        if (result.isEmpty() && locationConnectorToNext!=null) {
            result = locationConnectorToNext.getData(locationSearchDto);
            this.dataCache.save(locationSearchDto, result);
        }
        return result;

    }

}