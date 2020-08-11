package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyClassLoader {

    public LocationConnector load() {
        try {
            File jarFile = new File("LocationMock-1.0-SNAPSHOT.jar"); //   "LocationCalculator-1.0-SNAPSHOT.jar"
            java.lang.ClassLoader loader = URLClassLoader.newInstance(new URL[]{jarFile.toURL()});
            return (LocationConnector) loader.loadClass("implementation.ApiLocationMock").newInstance();
        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error inesperado leyendo el plugin: " + e.getMessage(), e);
        }
    }

    public LocationConnector loaded(String pathName, String className) {
        File file = new File(pathName);
        List<File> jars = Arrays.asList(file.listFiles()).stream().filter(i->i.getPath().endsWith(".jar")).collect(Collectors.toList());
        URL[] urls = new URL[jars.size()];
        for (int i = 0; i < jars.size(); i++) {
            try {
                urls[i] = jars.get(i).toURI().toURL();
            } catch (Exception e) {
                e.printStackTrace();
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
        MyClassLoader loader = new MyClassLoader();
        LocationConnector connector = loader.loaded("/home/jaimequispe/ungs/pp2/tp-maps-pp2/ungsmaps/jars", "implementation.LocationCalculatorConnector");
        System.out.println("connector is ok : " + connector.toString());
        // ApiLocationMock  LocationCalculatorConnector
    }

}