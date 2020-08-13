package factory;

import core.CustomerClassLoader;
import core.ClassFactory;

public class ClassLoaderFactory implements ClassFactory {

    private CustomerClassLoader customerClassLoader;

    public ClassLoaderFactory() {
        this.customerClassLoader = new CustomerClassLoader();
    }

    @Override
    public <C> C build(String pathName, String className) {
        return this.customerClassLoader.load(pathName, className);
    }

}