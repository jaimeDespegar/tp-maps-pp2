package model;

import java.util.List;

public interface DataCache {

    boolean save(LocationSearchDto locationSearchDto, List<Coordinate> data);
    boolean delete(LocationSearchDto locationSearchDto);
    boolean update(LocationSearchDto locationSearchDto, List<Coordinate> data);
    List<Coordinate> getAll();
    List<Coordinate> getRoadByCoordinates(LocationSearchDto locationSearchDto);

}