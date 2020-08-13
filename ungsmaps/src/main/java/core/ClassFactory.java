package core;

public interface ClassFactory {

    <C> C build(String pathName, String className);

}