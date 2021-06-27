package service;

import model.Customer;
import model.Driver;

import java.util.List;
import java.util.Set;

public interface IEligibleDriverStrategy {
    List<Driver> getEligibleDrivers(Customer customer, Set<Driver> onlineDrivers);
}
