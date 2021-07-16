package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class Driver {
    private final String name;
    private final Map<Customer,Float> ratings;
    private float avgRating;
    @Setter
    private Status status;

    public Driver(String name) {
        this.name = name;
        this.ratings = new HashMap<Customer, Float>();
        this.avgRating= Float.valueOf(0);
        this.status= Status.ONLINE;
    }

    public void addRating(Customer customer, Float rating){
        ratings.put(customer,rating);

        int totRatings=0;
        float calRatings =0;
        for(Customer cus : ratings.keySet()){
            totRatings++;
            calRatings += ratings.get(cus);
        }

        this.avgRating= calRatings/totRatings;
    }

    public Float getRatingByCustomer(Customer customer){
        if(!ratings.containsKey(customer)) return Float.valueOf(5);
        return ratings.get(customer);
    }

    public boolean hasDroveBefore(Customer customer){
        return ratings.containsKey(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
