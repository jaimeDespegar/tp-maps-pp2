package circuitBreaker.states;

import circuitBreaker.CircuitState;
import circuitBreaker.ICircuitBreaker;
import com.google.common.collect.Lists;
import model.Coordinate;
import java.util.List;

public class CloseCircuiteState implements CircuitState {

    private static final Integer MAX_COUNT_FAILS = 3;
    private Integer attempts = 0;

    @Override
    public List<Coordinate> call(ICircuitBreaker context, Coordinate from, Coordinate to) {
        try {
            return context.getProvider().getData(from, to);
        } catch (RuntimeException re) {
            this.attempts++;
            if (MAX_COUNT_FAILS.equals(this.attempts)) {
                context.setCurrentState(new OpenCircuitState());
            }
            return Lists.newArrayList();
        }
    }

}