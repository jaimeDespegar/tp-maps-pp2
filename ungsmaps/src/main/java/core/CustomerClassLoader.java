package core;

import exceptions.LoadingClassException;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerClassLoader {

    public <C> C load(String pathName, String className) {
        List<File> jars = this.findJars(pathName);
        URL[] urls = this.buildUrls(jars);
        URLClassLoader childClassLoader = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
        try {
            return (C) Class.forName(className, true, childClassLoader).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException c) {
            throw new LoadingClassException("Error cargando la clase " + className);
        }
    }

    private URL[] buildUrls(List<File> files) {
        URL[] urls = new URL[files.size()];
        for (int i = 0; i < files.size(); i++) {
            try {
                urls[i] = files.get(i).toURI().toURL();
            } catch (Exception e) {
                throw new RuntimeException("Error getting url of file: " + files.get(i), e);
            }
        }
        return urls;
    }

    private List<File> findJars(String pathName) {
        File file = new File(pathName);
        File[] files = Optional.of(file).map(File::listFiles).orElse(new File[]{});
        return Arrays.asList(files).stream().filter(i->i.getPath().endsWith(".jar")).collect(Collectors.toList());
    }

}