package circuitBreaker;

import com.google.common.collect.Lists;
import model.Coordinate;
import model.LocationConnector;
import utils.ManagerTimer;
import utils.MyTimer;

import java.util.List;

public class CircuitBreaker {

    private LocationConnector provider;
    private String state = "CLOSE";
    private Integer fails = 0;

    public CircuitBreaker(LocationConnector connector) {
        this.provider = connector;
    }

    public List<Coordinate> doSomething() {

        List<Coordinate> result = Lists.newArrayList();

        if (state.equalsIgnoreCase("CLOSE")) {
            try {
                result = this.provider.getData(null);
            } catch (RuntimeException re) {
                fails++;
            }
            if (fails == 3) {
                this.state = "OPEN";
            }
        }

        else if (state.equalsIgnoreCase("OPEN")) {
            ManagerTimer manager = new ManagerTimer(new MyTimer());
            manager.start();
            throw new OpenCircuitException("Circuit is Open: service not available");
        }

        else if (state.equalsIgnoreCase("HALF-OPEN")) {
            try {
                this.provider.getData(null);
                this.state = "CLOSE";
            } catch (RuntimeException re) {
                this.state = "OPEN";
            }
        }

        return result;
    }

}