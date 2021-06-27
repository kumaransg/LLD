package service;

import exception.CustomerNotFound;
import model.Customer;
import model.Driver;
import model.Status;

import java.util.*;

public class CabManager {
    Map<String, Customer> customerMapper;
    Map<String, Driver> driverMapper;
    IEligibleDriverStrategy eligibleStrategy;
    Set<Driver> onlineDrivers;

    public CabManager() {
        this.customerMapper = new HashMap<String, Customer>();
        this.driverMapper = new HashMap<String, Driver>();
        this.onlineDrivers = new HashSet<Driver>();
        this.eligibleStrategy = new EligibleDriverStrategy();
    }

    public void changeEligibleStrategy(IEligibleDriverStrategy newStrategy){
        this.eligibleStrategy= newStrategy;
    }

    public void changeDriverStatus(String driverName, boolean status){
        Driver driver= driverMapper.get(driverName);
        boolean currStatus= Status.ONLINE == driver.getStatus();

        if(currStatus == status) return;
        if(!currStatus){//going online
            onlineDrivers.add(driver);
            driver.setStatus(Status.ONLINE);
        }else{//going offline
            onlineDrivers.remove(driver);
            driver.setStatus(Status.OFFLINE);
        }
    }

    public List<Driver> getEligibleDriver(String customerName) throws CustomerNotFound {
        Customer customer= customerMapper.get(customerName);
        if(customer == null) throw new CustomerNotFound(customerName);

        System.out.println(customer);

        return  eligibleStrategy.getEligibleDrivers(customer,onlineDrivers);
    }

    public void addDriver(Driver driver){
        driverMapper.put(driver.getName(), driver);
        onlineDrivers.add(driver);
    }

    public Float getAverageRating(String customerName) throws CustomerNotFound {
        Customer customer= customerMapper.get(customerName);

        if(customer == null) throw new CustomerNotFound(customerName);
        return customer.getAvgRating();
    }

    public void addCustomer(String customerName){
        Customer newCustomer= new Customer(customerName);
        customerMapper.put(customerName, newCustomer);
        return;
    }

    public void addCustomer(Customer customer){
        customerMapper.put(customer.getName(), customer);
    }

    public void addTrip(String driverName, Float driverRating, String customerName, Float customerRating){
        Driver driver= driverMapper.get(driverName);
        Customer customer = customerMapper.get(customerName);

        if(driver == null){
            driver= new Driver(driverName);
        }

        addDriver(driver);

        if(customer == null){
            customer= new Customer(customerName);
        }

        addCustomer(customer);

        driver.addRating(customer, driverRating);
        customer.addRating(driver, customerRating);

        return;
    }

}
