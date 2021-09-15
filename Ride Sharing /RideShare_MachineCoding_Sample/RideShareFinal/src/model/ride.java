package model;

import java.util.*;

public class ride {

	private user rideGiver;
	private vehicle giverVehicle;
	private int available_seats;
	private String origin;
	private String destination;
	private Date startTime;
	private int ride_duration;


public ride(user u,vehicle v,int seats,String origin,String destination,Date startTime,int duration) {
	this.rideGiver =u;
	this.giverVehicle = v;
	this.available_seats =seats;
	this.origin = origin;
	this.destination = destination;
	this.startTime =startTime;
	this.ride_duration = duration;
}


public String getOrigin() {
	return origin;
}


public String getDestination() {
	return destination;
}


public vehicle getGiverVehicle() {
	return giverVehicle;
}


public int getRide_duration() {
	return ride_duration;
}


public Date getStartTime() {
	return startTime;
}


public int getAvailable_seats() {
	return available_seats;
}
public user getRideUser() {
	return this.rideGiver;
}


public void setAvailable_seats(int available_seats) {
	this.available_seats = available_seats;
}



}