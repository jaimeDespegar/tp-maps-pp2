package core;

import model.LocationConnector;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerClassLoader {

    public LocationConnector loaded(String pathName, String className) {
        File file = new File(pathName);
        File[] files = Optional.of(file).map(File::listFiles).orElse(new File[]{});
        List<File> jars = Arrays.asList(files).stream().filter(i->i.getPath().endsWith(".jar")).collect(Collectors.toList());

        URL[] urls = new URL[jars.size()];
        for (int i = 0; i < jars.size(); i++) {
            try {
                urls[i] = jars.get(i).toURI().toURL();
            } catch (Exception e) {
                throw new RuntimeException("Error getting url of jar");
            }
        }
        URLClassLoader childClassLoader = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
        try {
            return (LocationConnector) Class.forName(className, true, childClassLoader).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException c) {
            throw new RuntimeException("Error cargando la clase");
        }
    }

    public static void main(String[] args) {
        CustomerClassLoader loader = new CustomerClassLoader(); // ApiLocationMock  LocationCalculatorConnector
        LocationConnector connector = loader.loaded("/home/jaimequispe/ungs/pp2/tp-maps-pp2/ungsmaps/jars", "implementation.LocationCalculatorConnector");
        System.out.println("connector is ok : " + connector.toString());
    }

}