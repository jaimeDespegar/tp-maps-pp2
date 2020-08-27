package circuitBreaker.states;

import core.CircuitState;
import core.ICircuitBreaker;
import exceptions.OpenCircuitException;
import model.Coordinate;
import org.joda.time.DateTime;
import java.util.List;

public class OpenCircuitState implements CircuitState {

    private DateTime nextAttempt;
    private static final Integer SECONDS = 10;

    public OpenCircuitState() {
        this.nextAttempt = DateTime.now().plusSeconds(SECONDS);
    }

    @Override
    public List<Coordinate> call(ICircuitBreaker context, Coordinate from, Coordinate to) {
        DateTime now = DateTime.now();
        if (nextAttempt.isBefore(now)) {
            context.setCurrentState(new HalfOpenCircuitState());
        }
        throw new OpenCircuitException("Circuit is open: service is not available");
    }

}