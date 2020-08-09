package factory;

import implementation.ApiLocationMock;
import model.LocationConnector;
import model.ProviderFactory;

public class MockProviderFactory implements ProviderFactory {

    @Override
    public LocationConnector buildProvider() {
        return new ApiLocationMock();
    }

}