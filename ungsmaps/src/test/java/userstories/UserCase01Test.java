package userstories;

import core.CustomerClassLoader;
import exceptions.LoadingClassException;
import implementation.LocationMock;
import model.Coordinate;
import model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserCase01Test {

    private Location providerA, providerB, providerC;
    private CustomerClassLoader loader;
    private String pathInexist, pathEmpty, pathWithJar;

    @Before
    public void setUp() {
        this.providerA = new LocationMock();
        this.providerB = new LocationMock();
        this.providerC = new LocationMock();

        this.providerA.off();
        this.providerB.on();
        this.providerC.on();

        this.loader = new CustomerClassLoader();

        this.pathInexist = "/home/jaimequispe/noexists";
        this.pathEmpty = "/home/jaimequispe/ungs";
        this.pathWithJar = "/home/jaimequispe/ungs/pp2/jars";
    }

    @Test
    public void turnOn_providerA_Test() {
        this.providerA.on();
        Assert.assertTrue(this.providerA.isAvailable());
    }

    @Test
    public void turnOn_providerB_Test() {
        this.providerB.on();
        Assert.assertTrue(this.providerB.isAvailable());
    }

    @Test
    public void turnOff_providerC_Test() {
        this.providerC.off();
        Assert.assertFalse(this.providerC.isAvailable());
    }

    @Test
    public void providerB_resultCoordinatesEmptyTest() {
        List<Coordinate> road = this.providerB.getData(new Coordinate(23,41), new Coordinate(40,60));
        Assert.assertTrue(road.isEmpty());
    }

    @Test
    public void providerB_resultCoordinatesSizeOneTest() {
        List<Coordinate> road = this.providerB.getData(new Coordinate(22,66), new Coordinate(22,66));
        Assert.assertEquals(road.size(), 1);
    }

    @Test
    public void providerB_resultCoordinatesSizeThreeTest() {
        List<Coordinate> road = this.providerB.getData(new Coordinate(11,22), new Coordinate(33,44));
        Assert.assertEquals(road.size(), 3);
    }

    @Test
    public void loadProviderB_inPathInvalid_returnNull() {
        Assert.assertNull(this.loader.load(this.pathInexist, "implementation.LocationMock"));
    }

    @Test
    public void loadProviderB_inPathEmpty_returnNull() {
        Location provider = this.loader.load(this.pathEmpty, "implementation.LocationMock");
        Assert.assertNull(provider);
    }

    @Test(expected = LoadingClassException.class)
    public void loadProviderD_inPathWithJarOk_throwException() {
        this.loader.load(this.pathWithJar, "implementation.ProviderNotImplemented");
    }

    @Test
    public void loadProviderB_inPathWithJarOk_returnImplementation() {
        Location provider = this.loader.load(this.pathWithJar, "implementation.LocationMock");
        Assert.assertEquals(provider.getClass(), LocationMock.class);
    }

}