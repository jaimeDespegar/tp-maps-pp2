import factory.LocationServiceFactory;
import factory.ProviderFactory;
import core.Service;
import model.Coordinate;

public class App {

    public static void main(String[] args) {
        Service service = new LocationServiceFactory(new ProviderFactory()).build();
        service.getRoad(new Coordinate(1,2), new Coordinate(3, 4))
               .forEach(i->System.out.println(i.getX()+ " - "+ i.getY()));
    }

}