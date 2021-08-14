package logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import model.ride;
import model.user;
import model.vehicle;

public class rideService {
	//contains all rides
	public static List<ride> allOffers = new ArrayList<ride>();
	//contains data for all rides taken by which user
	public static HashMap<user,List<ride>> allRidesTaken = new HashMap<user,List<ride>>();

	public static ride offerRide(String name,String  RegNo,int seats,String origin,String destination,String startTime,int duration) throws Exception
	{			
		user u = userService.getUserByNameandRegNo(name,RegNo);
	
			if (u == null) {
			System.out.println("user "+name+" has no such vehicle "+RegNo+" so cannot offer such ride");
			return null;
				}
		vehicle v = userService.getVehicleByRegNo(RegNo);
		
		DateFormat format = new SimpleDateFormat("d MMM, yyyy HH", Locale.ENGLISH);//2 Feb, 2010 18
		Date date = format.parse(startTime);
		ride r =new ride(u,v,seats,origin,destination,date,duration);
		u.setRideOffered(u.getRideOffered()+1);// add ride offered to the user
		allOffers.add(r);
		return r;
	}
	
	private static ride selectRideService(user u,String origin,String destination,String type) {
		List<ride> specificRides= getAllAvailableRidesWithSourceAndDestinationForUser(u,origin,destination);
		
		if(specificRides.size()==0)
			return null;
		
		switch(type) {
		
		case "Fastest_Ride":{
			Collections.sort(specificRides, new fastestRide());
			return specificRides.get(0);
		}
			
		case "Earliest_Ride":{
			Collections.sort(specificRides,new earliestRide());
			return specificRides.get(0);
			}
			
		default:
			return null;

			
		}
	}
	
	public static ride selectRide(String name,String origin,String destination,String type) {
		user u = userService.getUserByName(name);
		
		if(u ==null){
			System.out.println("No such user is there "+ name);
			return null;
			}
		
		ride r = selectRideService(u,origin,destination,type);
		
		if (r== null) {
			System.out.println("No such ride is there with origin " + origin+ " Destination " +destination+" and type "+type);
			return null;
		}
		
		//change the state of ride offerer
		r.setAvailable_seats(r.getAvailable_seats()-1);	
		
		//change the state of ride taker
		u.setRidetaken(u.getRidetaken()+1);
		
		//map the user with which ride it takes
		if(allRidesTaken.containsKey(u)) {
			List<ride> rideByUser = allRidesTaken.get(u);
			rideByUser.add(r);
			
		}else {
			List<ride> rideByUser =new ArrayList<ride>();
			rideByUser.add(r);
			allRidesTaken.put(u,rideByUser);
		}
		
		System.out.println("Ride is given by "+r.getRideUser().getName()+" With Vehicle "+ r.getGiverVehicle().getCarRegNo()+" to "+u.getName());
		
		return r;
	}
	
	
	private static List<ride> getAllAvailableRidesWithSourceAndDestinationForUser(user u,String Source,String Destination){
		List<ride>specifiedRide = new ArrayList<ride>();
		for(ride r:allOffers) {
			//should not have same user
			// should be having same source and destination
			//should have available seats
			if(!(u.getIds().equals(r.getRideUser().getIds())) && r.getOrigin().equals(Source) && r.getDestination().equals(Destination) && r.getAvailable_seats()!=0) {
				specifiedRide.add(r);
			}
		}
		return specifiedRide;
	}
	
	public static void  fuelSavedByUser() {
			for(user u:allRidesTaken.keySet())	{
				List<ride> rides = allRidesTaken.get(u);
				int TotalFuelSaved =0;
				for(ride r :rides) {
					TotalFuelSaved+=r.getRide_duration();
				}
				System.out.println("Total fuel saved by "+u.getName()+":"+TotalFuelSaved);
			}
	}
	
	public static void totalRidesByUser() {
		
		for(user u:userService.allUsers) {
			System.out.println(u.getName()+" "+u.getRidetaken()+":"+"Taken"+" "+u.getRideOffered()+":"+"Offered");
		}
		
	}	
	
}


