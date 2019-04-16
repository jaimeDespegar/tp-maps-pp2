package main;

import builder.LocationSearchBuilder;
import factory.MockLocationFactory;
import model.LocationProxy;
import services.ServiceProxy;

public class App {

    public static void main(String[] args) {

        LocationProxy service = new ServiceProxy(new MockLocationFactory());
        service.getRoad(new LocationSearchBuilder().withArrival(22,66).withDeparture(22, 66).build())
               .forEach(i->System.out.println(i.getX()+ " - "+ i.getY()));

    }

}