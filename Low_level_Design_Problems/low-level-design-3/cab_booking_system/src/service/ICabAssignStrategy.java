package service;

import entity.Cab;
import entity.CabBookingRequest;

public interface ICabAssignStrategy {
  Cab assignCab(CabBookingRequest cabBookingRequest);
}
