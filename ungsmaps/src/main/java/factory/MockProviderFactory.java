package factory;

import model.LocationConnector;
import core.ProviderFactory;

public class MockProviderFactory implements ProviderFactory {

    @Override
    public LocationConnector buildProvider() {
        return null;
    }

}