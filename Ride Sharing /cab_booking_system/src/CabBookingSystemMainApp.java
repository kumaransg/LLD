import cab_manager.CabManager;
import entity.Cab;
import entity.CabBookingRequest;
import entity.Driver;
import entity.Location;
import entity.Rider;
import entity.RiderAccount;
import java.sql.DriverAction;
import rider_manager.RiderManager;

public class CabBookingSystemMainApp {
  public static void main(String[] args) {
    System.out.println("Init bab booking system...");
    Location cabLocation1 = new Location(10, 10);
    Location cabLocation2 = new Location(100, 100);
    Location cabLocation3 = new Location(10, 5);

    Driver driver1 = new Driver("Suresh1");
    Driver driver2 = new Driver("Suresh2");
    Driver driver3 = new Driver("Suresh3");

    Cab cab1 = new Cab(driver1, "AB1234", cabLocation1);

    Cab cab2 = new Cab(driver2, "DE1234", cabLocation2);

    Cab cab3 = new Cab(driver3, "FG1234", cabLocation3);

    CabManager.getInstance().addCab(cab1);
    CabManager.getInstance().addCab(cab2);
    CabManager.getInstance().addCab(cab3);

    Location riderLocation = new Location(5, 5);
    RiderAccount riderAccount = new RiderAccount("Mukesh");
    Rider rider = new Rider(riderAccount, riderLocation);

    RiderManager.getInstance().addRider(rider);

    CabBookingRequest cabBookingRequest = RiderManager.getInstance().requestCab(rider, new Location(20, 20));

    System.out.println(cabBookingRequest);

    System.out.println(cab3.getStatus());

    System.out.println(rider.getStatus());

    System.out.println(RiderManager.getInstance().findRider("Mukesh").getStatus());
  }
}
