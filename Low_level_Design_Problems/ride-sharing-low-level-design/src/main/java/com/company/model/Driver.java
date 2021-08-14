package com.company.model;

import lombok.Getter;
import lombok.Setter;

public class Driver {

  private final String name;

  @Getter private int id;

  @Getter @Setter private Trip currentTrip;

  @Setter private boolean isAcceptingRider;

  public Driver(int id, String name) {
    this.id = id;
    this.name = name;
    this.isAcceptingRider = true;
  }

  /**
   * Helper method to check whether driver can take new riders or not.
   *
   * @return
   */
  public boolean isAvailable() {
    return this.isAcceptingRider && this.currentTrip == null;
  }
}
