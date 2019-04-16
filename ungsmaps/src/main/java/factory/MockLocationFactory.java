package factory;

import implementation.ApiLocationMock;
import model.LocationConnector;
import model.LocationFactory;
import myCache.LocationCache;
import myCache.LocationData;

public class MockLocationFactory implements LocationFactory {

    @Override
    public LocationConnector buildCompositeConnector() {
        return new LocationCache(new ApiLocationMock(), new LocationData());
    }

}