import model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.IOnBoardingService;
import service.IRideService;


@Component
public class Driver {
    private static IOnBoardingService onBoardingService;
    private static IRideService rideService;

    @Autowired
    public Driver(IOnBoardingService onBoardingService, IRideService rideService) {
        this.onBoardingService = onBoardingService;
        this.rideService = rideService;
    }

    public static void main(String[] args) {

        //Onboard 5 users
        onBoardingService.add_user("Rohan","M",36);
        onBoardingService.add_vehicle("Rohan","Swift","KA-01-12345");
        onBoardingService.add_user("Shashank","M",29);
        onBoardingService.add_vehicle("Shashank","Baleno","TS-05-62395");
        onBoardingService.add_user("Nandani","F",29);
        onBoardingService.add_user("Shipra","F",27);
        onBoardingService.add_vehicle("Shipra","Baleno","TS-05-62395");
        onBoardingService.add_vehicle("Shipra","Activa","KA-12-12332");
        onBoardingService.add_user("Gaurav","M",29);
        onBoardingService.add_user("Rahul","M",35);
        onBoardingService.add_vehicle("Rahul","XUV","KA-05-1234");

        //Offer 4 rides by 3 users
        Ride r1= rideService.offer_ride("Rohan","Hyderabad","Bangalore",1,"Swift","KA-01-12345");
        Ride r2= rideService.offer_ride("Shipra","Bangalore","Mysore",1,"Activa","KA-12-12332");
        Ride r3= rideService.offer_ride("Shipra","Bangalore","Mysore",2,"Polo","KA-05-41491");
        rideService.offer_ride("Shashank","Hyderabad","Bangalore",2,"Baleno","TS-05-62395");
        rideService.offer_ride("Rahul","Hyderabad","Bangalore",5,"XUV","KA-05-1234");
        rideService.offer_ride("Rohan","Bangalore","Pune",1,"Swift","KA-01-12345");

        //Find rides for 4 users
        rideService.select_ride("Nandini","Bangalore","Mysore",1,"Most Vacant");
        rideService.select_ride("Gaurav","Bangalore","Mysore",1,"Preferred Vehicle=Activa");
        rideService.select_ride("Shashank","Mumbai","Bangalore",1,"Most Vacant");
        rideService.select_ride("Rohan","Hyderabad","Bangalore",1,"Preferred Vehicle=Baleno");
        rideService.select_ride("Shashank","Hyderabad","Bangalore",1,"Preferred Vehicle=Polo");

        //end-ride
        rideService.end_ride(r1);
        rideService.end_ride(r2);
        rideService.end_ride(r3);

    }
}
