package userstories;

import builder.LocationSearchBuilder;
import com.google.common.collect.Lists;
import model.Coordinate;
import model.LocationSearchDto;
import myCache.LocationData;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class UserCase03 {

    private LocationData locationData;
    private LocationSearchDto locationSearchDtoSaved;

    @BeforeClass
    public void setUp() {
        this.locationData = new LocationData();
        this.locationSearchDtoSaved = new LocationSearchBuilder().withArrival(22, 66).withDeparture(22, 66).build();
    }

    @BeforeMethod
    public void setUpMethod() {
        this.locationData.save(locationSearchDtoSaved, Lists.newArrayList(new Coordinate(22, 66)));
    }

    @Test
    public void getDataInCache_listSizeOneTest() {
        assertEquals(this.locationData.getAll().size(), 1);
    }

    @Test
    public void getDataInCache_listSizeEmptyTest() {
        LocationSearchDto dtoEmpty = new LocationSearchBuilder().withArrival(23, 41).withDeparture(50, 60).build();
        assertTrue(this.locationData.getRoadByCoordinates(dtoEmpty).isEmpty());
    }

    @Test
    public void saveDataInCache_listSizeTwoTest() {
        LocationSearchDto dtoEmpty = new LocationSearchBuilder().withArrival(23, 41).withDeparture(50, 60).build();
        this.locationData.save(dtoEmpty, Lists.newArrayList(new Coordinate(11, 22)));
        assertEquals(this.locationData.getAll().size(), 2);
    }

    @Test
    public void deleteDataInCache_listSizeEmptyTest() {
        this.locationData.delete(locationSearchDtoSaved);
        assertTrue(this.locationData.getAll().isEmpty());
    }

    @Test
    public void updateDataInCache_ValueUpdatedTest() {
        this.locationData.update(locationSearchDtoSaved, Lists.newArrayList(new Coordinate(99, 77)));
        List<Coordinate> result = this.locationData.getRoadByCoordinates(locationSearchDtoSaved);
        assertEquals(result.get(0), new Coordinate(99, 77));
    }

}