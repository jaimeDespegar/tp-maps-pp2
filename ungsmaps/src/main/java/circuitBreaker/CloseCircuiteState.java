package circuitBreaker;

import model.LocationConnector;

public class CloseCircuiteState implements CircuitState {

    private static final Integer MAX_COUNT_FAILS = 3;
    private Integer attempts = 0;

    @Override
    public void call(LocationConnector connector) {
        try {
            //MAX_COUNT_FAILS.equals(this.attempts)
            connector.getData(null);
        } catch (RuntimeException re) {
            this.attempts++;
        }
    }

    @Override
    public CircuitState nextState() {
        return new OpenCircuitState();
    }

}