package factory;

import model.LocationConnector;
import model.LocationFactory;

public class MockLocationFactory implements LocationFactory {

    @Override
    public LocationConnector buildCompositeConnector() {
        return null;
    }

}