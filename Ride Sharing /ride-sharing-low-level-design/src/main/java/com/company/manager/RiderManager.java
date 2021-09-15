package com.company.manager;

import com.company.exception.RiderAlreadyPresentException;
import com.company.exception.RiderNotFoundException;
import com.company.model.Rider;

import java.util.HashMap;
import java.util.Map;

/** Rider class is used to manage all riders present in the ride application. */
public class RiderManager {

  private Map<Integer, Rider> riders = new HashMap<>();

  /**
   * Method to add a new rider in the application.
   *
   * @param rider object
   * @throws RiderAlreadyPresentException exception
   */
  public void createRider(final Rider rider) {
    if (riders.containsKey(rider.getId())) {
      throw new RiderAlreadyPresentException(
          "Rider with rider Id = " + rider.getId() + " already present, try with different Id.");
    }

    riders.put(rider.getId(), rider);
  }

  /**
   * Method to get the Rider object for the given Rider ID.
   *
   * @param riderId integer
   * @return Rider Object
   * @throws RiderNotFoundException exception
   */
  public Rider getRider(final int riderId) {
    if (!riders.containsKey(riderId)) {
      throw new RiderNotFoundException("Rider with rider Id = " + riderId + " not found.");
    }

    return riders.get(riderId);
  }
}
