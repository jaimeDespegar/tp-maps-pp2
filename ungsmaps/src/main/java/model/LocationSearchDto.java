package model;

import com.google.common.base.Objects;

public class LocationSearchDto {

    private Coordinate departure;
    private Coordinate arrival;

    public LocationSearchDto() {}

    public LocationSearchDto(Coordinate departure, Coordinate arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Coordinate getDeparture() {
        return departure;
    }

    public void setDeparture(Coordinate departure) {
        this.departure = departure;
    }

    public Coordinate getArrival() {
        return arrival;
    }

    public void setArrival(Coordinate arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationSearchDto that = (LocationSearchDto) o;
        return Objects.equal(departure, that.departure) &&
                Objects.equal(arrival, that.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departure, arrival);
    }
}