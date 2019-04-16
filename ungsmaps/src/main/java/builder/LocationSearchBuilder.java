package builder;

import model.Coordinate;
import model.LocationSearchDto;

public class LocationSearchBuilder {

    private LocationSearchDto instance;

    public LocationSearchBuilder() {
        this.instance = new LocationSearchDto();
    }

    public LocationSearchBuilder withDeparture(Integer x, Integer y) {
        this.instance.setDeparture(new Coordinate(x, y));
        return this;
    }

    public LocationSearchBuilder withArrival(Integer x, Integer y) {
        this.instance.setArrival(new Coordinate(x, y));
        return this;
    }

    public LocationSearchDto build() {
        return this.instance;
    }

}