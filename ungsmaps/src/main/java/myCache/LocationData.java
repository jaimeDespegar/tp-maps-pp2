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

    private Map<LocationSearchDto, List<Coordinate>> myDataCache;

    public LocationData() {
        this.myDataCache = Maps.newHashMap();
    }

    public boolean save(LocationSearchDto locationSearchDto, List<Coordinate> data) {
        if(!this.myDataCache.containsKey(locationSearchDto) && !data.isEmpty())
            this.myDataCache.put(locationSearchDto, data);
        return true;
    }

    @Override
    public boolean delete(LocationSearchDto locationSearchDto) {
        return !myDataCache.remove(locationSearchDto).isEmpty();
    }

    @Override
    public boolean update(LocationSearchDto locationSearchDto, List<Coordinate> data) {
        return !myDataCache.replace(locationSearchDto, data).isEmpty();
    }

    @Override
    public List<Coordinate> getAll() {
        return new ArrayList(myDataCache.values());
    }

    public List<Coordinate> getRoadByCoordinates(LocationSearchDto locationSearchDto) {
        return myDataCache.getOrDefault(locationSearchDto, Lists.newArrayList());
    }

}