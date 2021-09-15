package model;

import exception.SeatNotVacantException;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Ride {
    private User driver;
    private String source;
    private String destination;
    private List<User> customers;
    private Date startTime;
    private Date endTime;
    private Vehicle vehicle;
    private int seats;

    public Ride(User driver, String src, String dest, int seats, Vehicle vehicle,String vehicleNumber){
        this.driver= driver;
        this.source= src;
        this.destination= dest;
        this.seats= seats;
        this.vehicle= vehicle;
    }

    public void addCustomer(User customer) throws SeatNotVacantException{
        if(seats == 0)
            throw new SeatNotVacantException("Seat not vacant in vehicle: "+ vehicle);
        customers.add(customer);
        seats--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return  getSeats() == ride.getSeats() &&
                Objects.equals(getDriver(), ride.getDriver()) &&
                Objects.equals(getSource(), ride.getSource()) &&
                Objects.equals(getDestination(), ride.getDestination()) &&
                Objects.equals(getCustomers(), ride.getCustomers()) &&
                Objects.equals(getStartTime(), ride.getStartTime()) &&
                Objects.equals(getEndTime(), ride.getEndTime()) &&
                Objects.equals(getVehicle(), ride.getVehicle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriver(), getSource(), getDestination(), getCustomers(), getStartTime(), getEndTime(), getVehicle(), getSeats());
    }
}
