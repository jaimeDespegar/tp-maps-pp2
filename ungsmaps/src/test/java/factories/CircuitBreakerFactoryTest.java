package factories;

import circuitBreaker.CircuitBreaker;
import core.CircuitFactory;
import core.ICircuitBreaker;
import factory.CircuitBreakerFactory;
import factory.ClassLoaderFactory;
import implementation.LocationMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircuitBreakerFactoryTest {

    private CircuitFactory instance;

    @Before
    public void setUp() {
        this.instance = new CircuitBreakerFactory();
    }

    @Test
    public void buildCircuitBreakerTest() {
        ICircuitBreaker circuitBreaker = this.instance.build(new LocationMock());
        Assert.assertEquals(circuitBreaker.getClass(), CircuitBreaker.class);
    }

}