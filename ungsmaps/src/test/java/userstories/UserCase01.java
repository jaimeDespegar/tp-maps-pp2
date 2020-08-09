package userstories;

import implementation.ApiLocationMock;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserCase01 {

    private ApiLocationMock providerA, providerB, providerC;

    @BeforeClass
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
        assertTrue(this.providerA.isAvailable());
    }

    @Test
    public void providerB_isActiveTest() {
        this.providerB.on();
        assertTrue(this.providerB.isAvailable());
    }

    @Test
    public void providerC_isNotActiveTest() {
        this.providerC.off();
        assertFalse(this.providerC.isAvailable());
    }

    @Test
    public void providerA_isNotActiveTest() {
        this.providerA.off();
        assertFalse(this.providerA.isAvailable());
    }


    @Test
    public void providerB_resultCoordinatesEmptyTest() {
        //LocationSearchDto locationSearchDtoEmpty = new LocationSearchBuilder().withArrival(23, 41).withDeparture(40, 60).build();
        assertTrue(this.providerB.getData(null, null).isEmpty());
    }

    @Test
    public void providerB_resultCoordinatesSizeOneTest() {
        //LocationSearchDto locationSearchDtoOne = new LocationSearchBuilder().withArrival(22, 66).withDeparture(22, 66).build();
        assertEquals(this.providerB.getData(null, null).size(), 1);
    }

    @Test
    public void providerB_resultCoordinatesSizeThreeTest() {
        //LocationSearchDto locationSearchDtoThree = new LocationSearchBuilder().withArrival(11, 22).withDeparture(33, 44).build();
        assertEquals(this.providerB.getData(null, null).size(), 3);
    }

}