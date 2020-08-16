package circuitBreaker;

import com.google.common.collect.Lists;
import core.CircuitState;
import core.ICircuitBreaker;
import model.Coordinate;
import model.LocationConnector;
import java.util.List;

public class CircuitBreaker implements ICircuitBreaker {

    private LocationConnector provider;
    private CircuitState state;

    public CircuitBreaker(LocationConnector connector, CircuitState initialState) {
        this.provider = connector;
        this.state = initialState;
    }

    @Override
    public List<Coordinate> doSomething(Coordinate arrival, Coordinate departure) {

        List<Coordinate> result;
        try {
            result = this.state.call(this, arrival, departure);
        } catch (OpenCircuitException oce) {
            System.out.println(oce.getMessage());
            result = Lists.newArrayList();
        }
        return result;
    }

    @Override
    public void setCurrentState(CircuitState currentState) {
        this.state = currentState;
    }

    @Override
    public LocationConnector getProvider() {
        return this.provider;
    }

    public static void main(String[] args) {
        ICircuitBreaker circuitBreaker = new CircuitBreaker(null, null);
        Coordinate from = new Coordinate(11, 22);
        Coordinate to = new Coordinate(33, 44);

        List<Coordinate> coordinates = circuitBreaker.doSomething(from, to);
        coordinates.forEach(i-> {
            System.out.println(i.getX() + " - "+i.getY());
        });
    }

}