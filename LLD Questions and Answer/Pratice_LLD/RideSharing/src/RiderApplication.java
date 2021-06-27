import Service.RideShareService;
import Service.RideShareServiceImpl;
import model.Driver;
import model.Rider;

import java.util.UUID;

public class RiderApplication {
    public static void main(String[] args) {
        Rider thomas = new Rider("thomas");
        Rider james = new Rider("james");
        Driver d1 = new Driver("tony shark");
        Driver d2 = new Driver("kumaran");

        /*
        service Fucntion calls
         */
        RideShareService rideShareService = new RideShareServiceImpl();
        rideShareService.addDrivers(d1);
        rideShareService.addDrivers(d2);
        rideShareService.addRiders(thomas);
        rideShareService.addRiders(james);

        //
        rideShareService.createRide(thomas.getId(),1,1,10,2);
        System.out.println(rideShareService.closeRide(thomas.getId(),1));
    }
}
