package entity;

import enums.CabStatus;
import java.util.HashMap;
import java.util.UUID;

public class BaseCab {
  Driver driver;
  Location location;
  CabStatus status;
  String license_plate;
  String color;

  public BaseCab(Driver driver, String license_plate, Location location){
    this.driver = driver;
    this.license_plate = license_plate;
    this.color = "UNKNOWN";
    this.location = location;
    this.status = CabStatus.AVAILABLE;
  }

  public BaseCab(Driver driver, String license_plate, Location location, String color){
    this.driver = driver;
    this.license_plate = license_plate;
    this.color = color;
    this.location = location;
    this.status = CabStatus.AVAILABLE;
  }

  public CabStatus getStatus() {
    return status;
  }

  public Driver getDriver() {
    return driver;
  }

  public Location getLocation() {
    return location;
  }

  public String getLicense_plate() {
    return license_plate;
  }

  public String getColor() {
    return color;
  }

  public void setStatus(CabStatus status) {
    this.status = status;
  }
}
