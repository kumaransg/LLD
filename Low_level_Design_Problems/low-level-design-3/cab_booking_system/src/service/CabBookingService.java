package service;

import entity.Cab;
import entity.CabBookingRequest;
import enums.CabBookingStatus;
import enums.CabStatus;
import enums.RiderStatus;

public class CabBookingService {
  ICabAssignStrategy cabAssignStrategy;

  public CabBookingService(){
    cabAssignStrategy = null;
  }

  public CabBookingService useStrategy(ICabAssignStrategy cabAssignStrategy){
    this.cabAssignStrategy = cabAssignStrategy;
    return this;
  }

  public void assignCab(CabBookingRequest cabBookingRequest){
    if(cabAssignStrategy == null){
      System.out.println("Cab strategy not defined!");
      return;
    }
    Cab foundCab = this.cabAssignStrategy.assignCab(cabBookingRequest);
    if(foundCab != null){
      foundCab.setStatus(CabStatus.BUSY);
      cabBookingRequest.setStatus(CabBookingStatus.BOOKED);
      cabBookingRequest.setAssignedTo(foundCab.getLicense_plate());
      cabBookingRequest.getRiderInfo().setStatus(RiderStatus.IN_RIDE);
      cabBookingRequest.getRiderInfo().addBookingRequest(cabBookingRequest);
      foundCab.getDriver().addBookingRequest(cabBookingRequest);
    }else{
      System.out.println("Cab not found in your location, please try after some time!");
    }
  }
}
