import exception.CustomerNotFound;
import service.CabManager;

import java.util.List;

public class Driver {
    public static void main(String[] args) throws Exception {
        CabManager cabManager= new CabManager();

        cabManager.addTrip("d1",Float.valueOf(1),"c1",Float.valueOf(4));
        cabManager.addTrip("d1",Float.valueOf(5),"c2",Float.valueOf(4));
        cabManager.addTrip("d1",Float.valueOf(1),"c3",Float.valueOf(2));
        cabManager.addTrip("d2",Float.valueOf(5),"c1",Float.valueOf(1));
        cabManager.addTrip("d2",Float.valueOf(5),"c2",Float.valueOf(5));
        cabManager.addTrip("d2",Float.valueOf(4),"c3",Float.valueOf(5));
        cabManager.addTrip("d3",Float.valueOf(3),"c1",Float.valueOf(1));
        cabManager.addTrip("d3",Float.valueOf(4),"c2",Float.valueOf(5));
        cabManager.addTrip("d3",Float.valueOf(3),"c3",Float.valueOf(5));


        List<model.Driver> eligibleDrivers = cabManager.getEligibleDriver("c1");

        for(model.Driver driver : eligibleDrivers)
            System.out.println(driver.getName() + " " + driver.getAvgRating());
    }
}
