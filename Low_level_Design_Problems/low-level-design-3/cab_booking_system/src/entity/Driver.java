package entity;

import java.util.HashMap;
import java.util.UUID;

public class Driver extends AbstractAccount {
  Double rating;
  HashMap<UUID, CabBookingRequest> cabBookingRequests;

  public Driver(String name) {
    super(name);
    this.rating = 3.0;
    cabBookingRequests = new HashMap<>();
  }

  public Driver(String name, String dob) {
    super(name, dob);
  }

  public Driver(String name, String dob, String address) {
    super(name, dob, address);
  }

  public  void addBookingRequest(CabBookingRequest cabBookingRequest){
    if(!cabBookingRequests.containsKey(cabBookingRequest.getId())){
      cabBookingRequests.put(cabBookingRequest.getId(), cabBookingRequest);
    }
  }

  public void updateBookingRequest(CabBookingRequest cabBookingRequest){
    if(cabBookingRequests.containsKey(cabBookingRequest.getId())){
      cabBookingRequests.put(cabBookingRequest.getId(), cabBookingRequest);
    }
  }

  public CabBookingRequest findBookingRequest(UUID id){
    if(cabBookingRequests.containsKey(id)){
      return  cabBookingRequests.get(id);
    }
    System.out.println("Cab booking request not found with id"+ id.toString());
    return null;
  }
}
