package model;

import java.util.List;

public interface Service {

    List<Coordinate> getRoad(Coordinate arrival, Coordinate departure);

}