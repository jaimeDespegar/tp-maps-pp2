package core;

import model.Location;

public interface CircuitFactory {

    ICircuitBreaker build(Location provider);

}