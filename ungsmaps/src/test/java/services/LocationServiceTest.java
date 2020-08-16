package services;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.states.CloseCircuiteState;
import implementation.ApiLocationMock;
import model.Coordinate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocationServiceTest {

    private LocationService instance;

    @Before
    public void setUp() {
        this.instance = new LocationService(new CircuitBreaker(new ApiLocationMock(), new CloseCircuiteState()));
    }

    @Test
    public void providerB_resultCoordinatesSizeThreeTest() {
        Assert.assertEquals(this.instance.getRoad(new Coordinate(11,22), new Coordinate(33,44)).size(), 3);
    }

}