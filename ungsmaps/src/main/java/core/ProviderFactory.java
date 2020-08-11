package core;

import model.LocationConnector;

public interface ProviderFactory {

    LocationConnector buildProvider();

}