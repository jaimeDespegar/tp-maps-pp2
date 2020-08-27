package factories;

import circuitBreaker.CircuitBreaker;
import circuitBreaker.states.CloseCircuiteState;
import core.Service;
import core.ServiceFactory;
import factory.LocationServiceFactory;
import implementation.LocationMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.LocationService;

public class ServiceFactoryTest {

    private ServiceFactory instance;

    @Before
    public void setUp() {
        this.instance = new LocationServiceFactory();
    }

    @Test
    public void buildLocationServiceTest() {
        Service service = this.instance.build(new CircuitBreaker(new LocationMock(), new CloseCircuiteState()));
        Assert.assertEquals(service.getClass(), LocationService.class);
    }

}