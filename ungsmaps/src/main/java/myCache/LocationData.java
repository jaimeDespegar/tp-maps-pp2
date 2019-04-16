package myCache;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import model.Coordinate;
import model.DataCache;
import model.LocationSearchDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationData implements DataCache {

    private Map<LocationSearchDto, List<Coordinate>> myDataCahe;

    public LocationData() {
        this.myDataCahe = Maps.newHashMap();
    }

    public boolean save(LocationSearchDto locationSearchDto, List<Coordinate> data) {
        if(!this.myDataCahe.containsKey(locationSearchDto) && !data.isEmpty())
            this.myDataCahe.put(locationSearchDto, data);
        return true;
    }

    @Override
    public boolean delete(LocationSearchDto locationSearchDto) {
        return !myDataCahe.remove(locationSearchDto).isEmpty();
    }

    @Override
    public boolean update(LocationSearchDto locationSearchDto, List<Coordinate> data) {
        return !myDataCahe.replace(locationSearchDto, data).isEmpty();
    }

    @Override
    public List<Coordinate> getAll() {
        return new ArrayList(myDataCahe.values());
    }

    public List<Coordinate> getRoadByCoordinates(LocationSearchDto locationSearchDto) {
        return myDataCahe.getOrDefault(locationSearchDto, Lists.newArrayList());
    }

}