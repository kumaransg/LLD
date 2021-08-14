package com.company.model;

import lombok.Getter;

import java.util.UUID;

public class Trip {

  @Getter private String id;

  @Getter private Rider rider;

  @Getter private Driver driver;

  private int origin;
  private int destination;
  private int seats;

  @Getter private double fare;

  @Getter private TripStatus status;

  public Trip(
      final Rider rider,
      final Driver driver,
      final int origin,
      final int destination,
      final int seats,
      final double fare) {
    this.id = UUID.randomUUID().toString();
    this.rider = rider;
    this.driver = driver;
    this.origin = origin;
    this.destination = destination;
    this.seats = seats;
    this.fare = fare;

    this.status = TripStatus.IN_PROGRESS;
  }

  public void updateTrip(
      final int origin, final int destination, final int seats, final double fare) {
    this.origin = origin;
    this.destination = destination;
    this.seats = seats;
    this.fare = fare;
  }

  public void endTrip() {
    this.status = TripStatus.COMPLETED;
  }

  public void withdrawTrip() {
    this.status = TripStatus.WITHDRAWN;
  }
}
