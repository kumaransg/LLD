package rider_manager;

import entity.CabBookingRequest;
import entity.Location;
import entity.Rider;
import java.util.HashMap;
import service.CabBookingService;
import service.SimpleCabAssignStrategy;

public class RiderManager {
  HashMap<String, Rider> riderHashMap;
  private static RiderManager instance = null;
  private RiderManager(){
    riderHashMap = new HashMap<>();
  }

  public static RiderManager getInstance(){
    if(instance == null){
      instance = new RiderManager();
    }
    return instance;
  }

  public Rider findRider(String name) {
    if(riderHashMap.containsKey(name)){
      return riderHashMap.get(name);
    }
    return null;
  }
  public void addRider(Rider rider){
    if(!riderHashMap.containsKey(rider.getRiderAccount().getName())){
      riderHashMap.put(rider.getRiderAccount().getName(), rider);
    }
  }

  public void removeRider(Rider rider){
    if(riderHashMap.containsKey(rider.getRiderAccount().getName())){
      riderHashMap.remove(rider.getRiderAccount().getName());
    }
  }

  public CabBookingRequest requestCab(Rider rider, Location toLocation){
    CabBookingRequest cabBookingRequest = new CabBookingRequest(rider.getLocation(), toLocation, rider);
    new CabBookingService().useStrategy(new SimpleCabAssignStrategy()).assignCab(cabBookingRequest);
    return cabBookingRequest;
  }
}
