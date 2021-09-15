package entity;

import constants.CabBookingConstants;
import java.util.HashMap;

public class Cab extends BaseCab {
  Double baseFare;
  Double perKMFare;
  public Cab(Driver driver, String license_plate, Location location){
    super(driver, license_plate, location);
    this.baseFare = CabBookingConstants.CAB_BASE_FARE;
    this.perKMFare = CabBookingConstants.CAB_PER_KM_CHARGE;
  }

  public Cab(Driver driver, String license_plate, Location location, String color){
    super(driver, license_plate, location, color);
    this.baseFare = CabBookingConstants.CAB_BASE_FARE;
    this.perKMFare = CabBookingConstants.CAB_PER_KM_CHARGE;
  }

  public Double getBaseFare() {
    return baseFare;
  }

  public Double getPerKMFare() {
    return perKMFare;
  }

  public void setBaseFare(Double baseFare) {
    this.baseFare = baseFare;
  }

  public void setPerKMFare(Double perKMFare) {
    this.perKMFare = perKMFare;
  }
}
