package model;

import java.util.List;

public interface LocationProxy {

    List<Coordinate> getRoad(LocationSearchDto locationSearchDto);

}