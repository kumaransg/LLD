package logic;

import java.util.ArrayList;

import java.util.List;

import model.user;
import model.vehicle;

public class userService {
	public static List<user> allUsers  = new ArrayList<user>();
	public static List<vehicle>allVehicle = new ArrayList<vehicle>();
	
       //creates new user
    public static user createUser(String name, int age ,char gender) {
    	user u = new user(name,gender,age);
    	allUsers.add(u);
    	return u;
    }
    
    //add vehicle to the u user
	public static vehicle addVehicle(user u,String owner,String Model,String RegNo) {
		vehicle v = new vehicle(owner,Model,RegNo);
		u.addVehicle(v);
		allVehicle.add(v);
		return v;
}
	//if user with one name is there
	public static vehicle addVehicle(String owner,String Model,String RegNo) {
		user  u= getUserByName(owner);
		if(u==null)
			return null;
		
		vehicle v = new vehicle(owner,Model,RegNo);
		u.addVehicle(v);
		allVehicle.add(v);
		return v;
	}
	
	public static user getUserByName(String name) {			
		for(user u:allUsers) {
			if (u.getName().equals(name))
					return u;
		}
		return null;

	}
	public static vehicle getVehicleByRegNo(String RegNo) {
		for(vehicle v:allVehicle) {
			if(v.getCarRegNo().equals(RegNo)) {
				return v;
			}
		}
		return null;
	}
	
	public static user getUserByNameandRegNo(String name,String RegNo) {
		vehicle v =  getVehicleByRegNo(RegNo);
		if (v==null) {
			return null;
		}
		for(user u:allUsers) {
			if(u.getName().equals(name) && u.getVehicle().contains(v)) {
				return u;
			}
		}
		return null;
	}

}
