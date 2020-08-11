package factory;

import core.CustomerClassLoader;
import model.LocationConnector;
import core.ClassFactory;

public class ProviderFactory implements ClassFactory<LocationConnector> {

    private static final String PATH = "/home/jaimequispe/ungs/pp2/tp-maps-pp2/ungsmaps/jars";
    private static final String CLASS_NAME = "implementation.LocationCalculatorConnector"; // ApiLocationMock       LocationCalculatorConnector
    private CustomerClassLoader customerClassLoader;

    public ProviderFactory() {
        this.customerClassLoader = new CustomerClassLoader();
    }

    @Override
    public LocationConnector buildClass() {
        return this.customerClassLoader.loaded(PATH, CLASS_NAME);
    }

}