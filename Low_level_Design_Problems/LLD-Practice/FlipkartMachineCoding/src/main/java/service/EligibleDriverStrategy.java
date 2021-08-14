package service;

import model.Customer;
import model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EligibleDriverStrategy implements IEligibleDriverStrategy{
    public List<Driver> getEligibleDrivers(Customer customer, Set<Driver> onlineDrivers) {
        List<Driver> eligibleDrivers= new ArrayList<Driver>();

        for(Driver driver : onlineDrivers){
            if(driver.getAvgRating() >= customer.getAvgRating()){
                float ratingByDriver= customer.getRatingByDriver(driver);
                float ratingByCustomer= driver.getRatingByCustomer(customer);

                if(ratingByCustomer == 1.0 || ratingByDriver == 1.0) continue;

                eligibleDrivers.add(driver);
            }
        }

        if(eligibleDrivers.size() > 0) return eligibleDrivers;

        //if no found , send the drivers with whom he has drove before
        for(Driver driver : onlineDrivers){
            if(driver.hasDroveBefore(customer)){
                Float ratingByDriver= customer.getRatingByDriver(driver);
                Float ratingByCustomer= driver.getRatingByCustomer(customer);

                if(ratingByCustomer == 1.0 || ratingByDriver == 1.0) continue;

                eligibleDrivers.add(driver);
            }
        }

        return eligibleDrivers;
    }
}
