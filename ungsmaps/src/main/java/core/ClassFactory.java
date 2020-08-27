package core;

public interface ClassFactory {

    <C> C load(String pathName, String className);

}