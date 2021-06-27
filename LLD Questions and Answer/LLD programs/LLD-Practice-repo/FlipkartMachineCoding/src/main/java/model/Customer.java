package model;

import lombok.Getter;

import java.util.*;

@Getter
public class Customer {
    private final String name;
    private final Map<Driver, Float> ratings;
    private float avgRating;

    public Customer(String name) {
        this.name = name;
        this.ratings = new HashMap<Driver, Float>();
        this.avgRating= Float.valueOf(0);
    }

    public void addRating(Driver driver, Float rating){
        ratings.put(driver,rating);

        int totRatings=0;
        float calRatings =0;
        for(Driver cus : ratings.keySet()){
            totRatings++;
            calRatings += ratings.get(cus);
        }

        this.avgRating= calRatings/totRatings;
    }

    public Float getRatingByDriver(Driver driver){
        if(!ratings.containsKey(driver)) return Float.valueOf(5);
        return ratings.get(driver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
