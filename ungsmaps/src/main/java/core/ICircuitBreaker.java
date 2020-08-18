package core;

import model.Coordinate;
import model.Location;
import java.util.List;

public interface ICircuitBreaker {

    List<Coordinate> doSomething(Coordinate arrival, Coordinate departure);
    void setCurrentState(CircuitState currentState);
    Location getProvider();

}