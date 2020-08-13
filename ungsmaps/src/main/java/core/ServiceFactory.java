package core;

import model.LocationConnector;

public interface ServiceFactory {

    Service build(LocationConnector connector);

}