package model;

import java.util.List;

public interface Service {

    List<Coordinate> getRoad(LocationSearchDto locationSearchDto);

}