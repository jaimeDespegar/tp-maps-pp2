package main;

import circuitBreaker.CircuitBreaker;
import factory.MockProviderFactory;
import model.Service;
import services.LocationService;

public class App {

    public static void main(String[] args) {
        Service service = new LocationService(new CircuitBreaker(new MockProviderFactory().buildProvider()));
        service.getRoad(null, null).forEach(i->System.out.println(i.getX()+ " - "+ i.getY()));
    }

}