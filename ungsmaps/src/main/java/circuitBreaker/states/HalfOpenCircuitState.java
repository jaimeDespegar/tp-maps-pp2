package circuitBreaker.states;

import core.CircuitState;
import core.ICircuitBreaker;
import com.google.common.collect.Lists;
import model.Coordinate;
import java.util.List;

public class HalfOpenCircuitState implements CircuitState {

    @Override
    public List<Coordinate> call(ICircuitBreaker context, Coordinate from, Coordinate to) {
        try {
            List<Coordinate> list = context.getProvider().getData(from, to);
            context.setCurrentState(new CloseCircuitState());
            return list;
        } catch (RuntimeException e) {
            context.setCurrentState(new OpenCircuitState());
            return Lists.newArrayList();
        }
    }

}