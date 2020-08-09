package model;

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

}