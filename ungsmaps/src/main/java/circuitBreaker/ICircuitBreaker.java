package circuitBreaker;

import model.Coordinate;
import model.LocationConnector;
import java.util.List;

public interface ICircuitBreaker {

    List<Coordinate> doSomething(Coordinate arrival, Coordinate departure);
    void setCurrentState(CircuitState currentState);
    LocationConnector getProvider();

}