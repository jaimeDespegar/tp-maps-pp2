package main;

import builder.LocationSearchBuilder;
import factory.MockLocationFactory;
import model.LocationProxy;
import services.ServiceProxy;

public class App {

    public static void main(String[] args) {

        LocationProxy service = new ServiceProxy(new MockLocationFactory());
        service.getRoad(new LocationSearchBuilder().withArrival(23,41).withDeparture(50, 60).build())
               .forEach(i->System.out.println(i.getX()+ " - "+ i.getY()));

    }

}