package com.company;

import com.company.exception.DriverNotFoundException;
import com.company.exception.InvalidRideParamException;
import com.company.exception.TripNotFoundException;
import com.company.exception.TripStatusException;
import com.company.manager.DriverManager;
import com.company.manager.RiderManager;
import com.company.manager.TripManager;
import com.company.model.Driver;
import com.company.model.Rider;
import com.company.model.Trip;
import com.company.model.TripStatus;
import com.company.strategy.DefaultPricingStrategy;
import com.company.strategy.OptimalDriverStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class TripManagerTest {

  TripManager tripManager;
  Driver driver1, driver2;
  Rider rider1, rider2, rider3;

  @BeforeEach
  void setup() {

    driver1 = new Driver(1, "Driver1");
    driver2 = new Driver(2, "Driver2");

    DriverManager driverManager = new DriverManager();
    driverManager.createDriver(driver1);
    driverManager.createDriver(driver2);

    rider1 = new Rider(1, "Rider1");
    rider2 = new Rider(2, "Rider2");
    rider3 = new Rider(3, "Rider3");

    RiderManager riderManager = new RiderManager();
    riderManager.createRider(rider1);
    riderManager.createRider(rider2);
    riderManager.createRider(rider3);

    tripManager =
        new TripManager(
            riderManager, driverManager, new DefaultPricingStrategy(), new OptimalDriverStrategy());
  }

  @Test
  void test_createRideMethod() {

    // Given.
    // Driver1 booked by rider1, one driver left now.
    tripManager.createTrip(rider1, 50, 60, 1);

    // Driver2 booked by rider2, zero driver left now.
    tripManager.createTrip(rider2, 60, 70, 2);

    // Then.
    assertThrows(
        DriverNotFoundException.class,
        () -> {
          // When.
          tripManager.createTrip(rider3, 80, 100, 2);
        });

    assertThrows(
        InvalidRideParamException.class,
        () -> {
          tripManager.createTrip(rider3, 50, 40, 1);
        });
  }

  @Test
  void test_updateTripWithWrongTripId() {

    // Then.
    Assertions.assertThrows(
        InvalidRideParamException.class,
        () -> {
          // When.
          tripManager.updateTrip("random-id", 40, 10, 1);
        });
  }

  @Test
  void test_updateTripWithWrongDetails() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);

    // Then.
    Assertions.assertThrows(
        InvalidRideParamException.class,
        () -> {
          // When.
          tripManager.updateTrip(tripId, 40, 10, 1);
        });
  }

  @Test
  void test_updateTripWhichIsAlreadyCompletedOrWithdrawn() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);
    Driver driver = tripManager.getDriverForTrip(tripId).get();
    tripManager.endTrip(driver);

    // Then.
    Assertions.assertThrows(
        TripStatusException.class,
        () -> {
          // When.
          tripManager.updateTrip(tripId, 10, 50, 1);
        });
  }

  @Test
  void test_updateTripFareBasedOnNewDetails() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);

    // When.
    tripManager.updateTrip(tripId, 20, 40, 1);
    Driver driver = tripManager.getDriverForTrip(tripId).get();

    // Then.
    Assertions.assertEquals(400, tripManager.endTrip(driver));
  }

  @Test
  void test_updateTripWithInvalidTripId() {

    // Then.
    Assertions.assertThrows(
        TripNotFoundException.class,
        () -> {
          // When.
          tripManager.updateTrip("1234", 10, 20, 2);
        });
  }

  @Test
  void test_withdrawTrip() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);

    // When.
    tripManager.withdrawTrip(tripId);
    Trip trip =
        tripManager.tripHistory(rider1).parallelStream()
            .filter(t -> t.getId().equals(tripId))
            .findAny()
            .get();

    // Then.
    Assertions.assertEquals(TripStatus.WITHDRAWN, trip.getStatus());
  }

  @Test
  void test_withdrawTripWithInvalidTripId() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);

    // Then.
    Assertions.assertThrows(
        TripNotFoundException.class,
        () -> {
          // When.
          tripManager.withdrawTrip("randomId");
        });
  }

  @Test
  void test_withdrawTripWhichIsAlreadyCompleted() {

    // Given.
    String tripId = tripManager.createTrip(rider1, 10, 20, 2);
    Driver driver = tripManager.getDriverForTrip(tripId).get();
    tripManager.endTrip(driver);

    // Then.
    Assertions.assertThrows(
        TripStatusException.class,
        () -> {
          // When.
          tripManager.withdrawTrip(tripId);
        });
  }

  @Test
  void test_endRideAndAddAcceptNewRiderRequest() {

    // Given.
    String trip1 = tripManager.createTrip(rider1, 20, 60, 2);
    String trip2 = tripManager.createTrip(rider2, 40, 70, 2);

    // End the trip of rider2 and book the ride of rider3.
    Driver driverForRider2 = tripManager.getDriverForTrip(trip2).get();

    // When.
    assertEquals(900, tripManager.endTrip(driverForRider2));

    // Then.
    tripManager.createTrip(rider3, 80, 100, 2);
  }

  @Test
  void test_getFareForDriverWhenNotRiding() {
    // Then.
    assertThrows(
        TripNotFoundException.class,
        () -> {
          // When.
          tripManager.endTrip(driver1);
        });
  }

  @Test
  void test_preferredRiderFareCalculation() {

    // When rider has completed more than 10 rides, he become preferred rider.
    IntStream.range(1, 12)
        .forEach(
            i -> {
              String tripId = tripManager.createTrip(rider1, i * 10, (i + 1) * 10, 1);
              Driver driverForRider1 = tripManager.getDriverForTrip(tripId).get();
              tripManager.endTrip(driverForRider1);
            });

    // Then.
    assertTrue(tripManager.tripHistory(rider1).size() == 11);

    String tripId = tripManager.createTrip(rider1, 10, 20, 2);
    Driver driverForRider1 = tripManager.getDriverForTrip(tripId).get();

    assertEquals(200, tripManager.endTrip(driverForRider1));
  }
}
