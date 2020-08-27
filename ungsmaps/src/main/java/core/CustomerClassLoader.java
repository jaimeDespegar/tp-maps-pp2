package core;

import exceptions.LoadingClassException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerClassLoader {

    public <C> C load(String pathName, String className) {
        List<File> jars = this.findJars(pathName);
        if (jars.isEmpty())
            return null;
        try {
            URL[] urls = this.buildUrls(jars);
            URLClassLoader childClassLoader = new URLClassLoader(urls);
            return (C) Class.forName(className, true, childClassLoader).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException c) {
            throw new LoadingClassException("Error cargando la clase " + className);
        }
    }

    private URL[] buildUrls(List<File> files) throws MalformedURLException {
        URL[] urls = new URL[files.size()];
        for (int i = 0; i < files.size(); i++) {
            urls[i] = files.get(i).toURI().toURL();
        }
        return urls;
    }

    private List<File> findJars(String pathName) {
        File file = new File(pathName);
        File[] files = Optional.of(file).map(File::listFiles).orElse(new File[]{});
        return Arrays.asList(files).stream().filter(i->i.getPath().endsWith(".jar")).collect(Collectors.toList());
    }

}