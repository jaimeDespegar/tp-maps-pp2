package core;

public interface ServiceFactory {

    Service build(ICircuitBreaker circuitBreaker);

}