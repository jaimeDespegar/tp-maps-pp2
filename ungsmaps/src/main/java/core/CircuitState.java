package core;

import model.Coordinate;
import java.util.List;

public interface CircuitState {

    List<Coordinate> call(ICircuitBreaker context, Coordinate from, Coordinate to);

}