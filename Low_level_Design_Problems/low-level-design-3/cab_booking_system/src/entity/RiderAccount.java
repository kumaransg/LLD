package entity;

public class RiderAccount extends AbstractAccount {

  public RiderAccount(String name) {
    super(name);
  }

  public RiderAccount(String name, String dob) {
    super(name, dob);
  }

  public RiderAccount(String name, String dob, String address) {
    super(name, dob, address);
  }
}
