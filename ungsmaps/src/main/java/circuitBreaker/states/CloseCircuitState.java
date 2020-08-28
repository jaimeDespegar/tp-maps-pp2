package circuitBreaker.states;

import core.CircuitState;
import core.ICircuitBreaker;
import com.google.common.collect.Lists;
import model.Coordinate;
import java.util.List;

public class CloseCircuitState implements CircuitState {

    private static final Integer MAX_COUNT_FAILS_DEFAULT = 3;
    private Integer maxCountFails;
    private Integer attempts = 0;

    public CloseCircuitState(Integer maxCountFails) {
        this.maxCountFails = maxCountFails;
    }

    public CloseCircuitState() {
        this(MAX_COUNT_FAILS_DEFAULT);
    }

    @Override
    public List<Coordinate> call(ICircuitBreaker context, Coordinate from, Coordinate to) {
        try {
            return context.getProvider().getData(from, to);
        } catch (RuntimeException re) {
            this.attempts++;
            if (this.maxCountFails.equals(this.attempts)) {
                context.setCurrentState(new OpenCircuitState());
            }
            return Lists.newArrayList();
        }
    }

}