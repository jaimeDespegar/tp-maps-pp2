package userstories;

import implementation.ApiLocationMock;
import model.Coordinate;
import model.LocationConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserCase01Test {

    private LocationConnector providerA, providerB, providerC;

    @Before
    public void setUp() {
        this.providerA = new ApiLocationMock();
        this.providerB = new ApiLocationMock();
        this.providerC = new ApiLocationMock();

        this.providerA.off();
        this.providerB.on();
        this.providerC.on();
    }

    @Test
    public void providerA_isActiveTest() {
        this.providerA.on();
        Assert.assertTrue(this.providerA.isAvailable());
    }

    @Test
    public void providerB_isActiveTest() {
        this.providerB.on();
        Assert.assertTrue(this.providerB.isAvailable());
    }

    @Test
    public void providerC_isNotActiveTest() {
        this.providerC.off();
        Assert.assertFalse(this.providerC.isAvailable());
    }

    @Test
    public void providerA_isNotActiveTest() {
        this.providerA.off();
        Assert.assertFalse(this.providerA.isAvailable());
    }


    @Test
    public void providerB_resultCoordinatesEmptyTest() {
        //LocationSearchDto locationSearchDtoEmpty = new LocationSearchBuilder().withArrival(23, 41).withDeparture(40, 60).build();
        Assert.assertTrue(this.providerB.getData(new Coordinate(23,41), new Coordinate(40,60)).isEmpty());
    }

    @Test
    public void providerB_resultCoordinatesSizeOneTest() {
        //LocationSearchDto locationSearchDtoOne = new LocationSearchBuilder().withArrival(22, 66).withDeparture(22, 66).build();
        Assert.assertEquals(this.providerB.getData(new Coordinate(22,66), new Coordinate(22,66)).size(), 1);
    }

    @Test
    public void providerB_resultCoordinatesSizeThreeTest() {
        //LocationSearchDto locationSearchDtoThree = new LocationSearchBuilder().withArrival(11, 22).withDeparture(33, 44).build();
        Assert.assertEquals(this.providerB.getData(new Coordinate(11,22), new Coordinate(33,44)).size(), 3);
    }

}