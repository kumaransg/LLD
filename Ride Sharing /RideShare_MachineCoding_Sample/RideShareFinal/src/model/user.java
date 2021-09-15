package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class user {
	
	private String ids;
	private String name;
	private char gender;
	private int age;
	private List <vehicle> vehicles;
	private int ridetaken;
	private int rideOffered;
	
	public user(String name,char gender,int age) {
		this.ids = UUID.randomUUID().toString();;
		this.name = name;
		this.gender =gender;
		this.age = age;
		this.vehicles = new ArrayList<vehicle>();
		this.rideOffered =0;
		this.ridetaken =0;

	}

	public String getIds() {
		return ids;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
	public void addVehicle(vehicle v) {
		this.vehicles.add(v);
	}
	
	public void setRidetaken(int ridetaken) {
		this.ridetaken = ridetaken;
	}

	public void setRideOffered(int rideOffered) {
		this.rideOffered = rideOffered;
	}

	public int getRidetaken() {
		return ridetaken;
	}

	public int getRideOffered() {
		return rideOffered;
	}

	public List<vehicle> getVehicle() {
		return this.vehicles;
	}
	public boolean hasVehicle(vehicle v) {
		if (this.vehicles.contains(v))
			return true;
		return false;
	}
	
	public int getNofVehicles() {
		return this.vehicles.size();
	}

}
