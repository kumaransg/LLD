package service;

import cab_manager.CabManager;
import constants.CabBookingConstants;
import entity.Cab;
import entity.CabBookingRequest;
import entity.Location;
import java.util.ArrayList;
import org.omg.CORBA.INTERNAL;

public class SimpleCabAssignStrategy implements ICabAssignStrategy {

  @Override
  public Cab assignCab(CabBookingRequest cabBookingRequest){
    ArrayList<Cab> cabs = CabManager.getInstance().findAvailableCabs();
    Double minDistance = CabBookingConstants.MAX_PICKUP_DISTANCE;
    Cab foundCab = null;
    for(int i  = 0; i < cabs.size(); i++) {
      // max pickup distance logic and return one cab;
      Double distance = calculateDistance(cabs.get(i).getLocation(), cabBookingRequest.getRiderInfo().getLocation());
      if(distance <=  minDistance){
        minDistance = distance;
        foundCab = cabs.get(i);
      }
    }
    return  foundCab;
  }

  private Integer getDiffSquare(Integer n1, Integer n2) {
    return (n1-n2) * (n1-n2);
  }
  private Double calculateDistance(Location p1, Location p2){
    return Math.sqrt(getDiffSquare(p1.getX(), p2.getX()) + getDiffSquare(p1.getY(), p2.getY()));
  }
}
