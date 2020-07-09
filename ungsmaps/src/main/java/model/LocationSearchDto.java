package model;

import java.util.Objects;

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

    // TODO eliminar?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationSearchDto that = (LocationSearchDto) o;
        return Objects.equals(departure, that.departure) &&
                Objects.equals(arrival, that.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departure);
    }

}