package circuitBreaker;

import model.LocationConnector;
import org.joda.time.DateTime;

public class OpenCircuitState implements CircuitState {

    private DateTime nextAttempt;
    private Integer secords = 10;

    public OpenCircuitState() {
        this.nextAttempt = DateTime.now().plusSeconds(this.secords);
    }

    @Override
    public void call(LocationConnector connector) {
        DateTime now = DateTime.now();
        if (nextAttempt.isAfter(now)) {
            // next state
        }
        throw new OpenCircuitException("Circuit is open: service is not available");
    }

    @Override
    public CircuitState nextState() {
        return new HalfOpenCircuitState();
    }

}