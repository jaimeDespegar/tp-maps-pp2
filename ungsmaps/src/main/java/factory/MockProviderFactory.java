package factory;

import model.LocationConnector;
import model.ProviderFactory;

public class MockProviderFactory implements ProviderFactory {

    @Override
    public LocationConnector buildProvider() {
        return null;
    }

}