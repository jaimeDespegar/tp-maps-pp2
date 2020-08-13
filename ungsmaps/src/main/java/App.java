import factory.LocationServiceFactory;
import factory.ClassLoaderFactory;
import core.Service;
import model.Coordinate;
import model.LocationConnector;

public class App {

    public static void main(String[] args) {
        String path = "/home/jaimequispe/ungs/pp2/jars";
        String className = "implementation.ApiLocationMock";

        LocationConnector connector = new ClassLoaderFactory().build(path, className);
        Service service = new LocationServiceFactory().build(connector);
        service.getRoad(new Coordinate(11,22), new Coordinate(33,44))
               .forEach(i->System.out.println(i.getX()+ " - "+ i.getY()));
    }

}