package userstories;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.states.*;
import core.CircuitState;
import core.ICircuitBreaker;
import exceptions.OpenCircuitException;
import implementation.LocationMock;
import model.Coordinate;
import model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

public class UserCase02Test {

    private ICircuitBreaker circuitBreakerClose, circuitBreakerCloseFail, circuitBreakerFail,
                            circuitBreakerHalfOpenOk, circuitBreakerHalfOpenFail;
    private Location providerA;
    @Mock
    private Location providerFail;
    private CircuitState stateOpen;
    private Coordinate from, to;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        this.providerA = new LocationMock();
        this.stateOpen = new OpenCircuitState();

        this.circuitBreakerClose = new CircuitBreaker(providerA, new CloseCircuitState());
        this.circuitBreakerCloseFail = new CircuitBreaker(providerFail, new CloseCircuitState(1));
        this.circuitBreakerFail = new CircuitBreaker(providerA, this.stateOpen);
        this.circuitBreakerHalfOpenOk = new CircuitBreaker(providerA, new HalfOpenCircuitState());
        this.circuitBreakerHalfOpenFail = new CircuitBreaker(providerFail, new HalfOpenCircuitState());

        this.from = new Coordinate(11, 22);
        this.to = new Coordinate(33, 44);

        Mockito.when(this.providerFail.getData(Mockito.any(), Mockito.any())).thenThrow(RuntimeException.class);
    }

    @Test
    public void circuitIsClose_withProvederA_thenReturnRoadWithThreeCoordinates_test() {
        List<Coordinate> road = this.circuitBreakerClose.doSomething(this.from, this.to);
        Assert.assertEquals(road.size(), 3);
    }

    @Test
    public void circuitIsClose_withProvederB_thenReturnEmptyRoad_test() {
        List<Coordinate> road = this.circuitBreakerCloseFail.doSomething(this.from, this.to);
        Assert.assertTrue(road.isEmpty());
    }

    @Test
    public void circuitIsOpen_thenReturnEmptyRoad_test() {
        List<Coordinate> road = this.circuitBreakerFail.doSomething(this.from, this.to);
        Assert.assertTrue(road.isEmpty());
    }

    @Test
    public void circuitIsHalfOpen_withProviderA_theRoadWithThreeCoordinates_test() {
        List<Coordinate> road = this.circuitBreakerHalfOpenOk.doSomething(this.from, this.to);
        Assert.assertEquals(road.size(), 3);
    }

    @Test
    public void circuitIsHalfOpen_withProviderB_thenReturnEmptyRoad_test() {
        List<Coordinate> road = this.circuitBreakerHalfOpenFail.doSomething(this.from, this.to);
        Assert.assertTrue(road.isEmpty());
    }

    @Test(expected = OpenCircuitException.class)
    public void stateOpen_alwaysThrowException() {
        this.stateOpen.call(circuitBreakerFail, this.from, this.to);
    }

}