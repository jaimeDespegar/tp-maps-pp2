package circuitBreaker;

import com.google.common.collect.Lists;
import core.CircuitState;
import core.ICircuitBreaker;
import exceptions.OpenCircuitException;
import model.Coordinate;
import model.Location;
import java.util.List;

public class CircuitBreaker implements ICircuitBreaker {

    private Location provider;
    private CircuitState state;

    public CircuitBreaker(Location connector, CircuitState initialState) {
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
    public Location getProvider() {
        return this.provider;
    }

}