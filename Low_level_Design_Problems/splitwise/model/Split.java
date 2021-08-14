package io.abhishek.machinecoding.splitwise.model;

public abstract class Split {
  private User user;
  double amount;

  public Split(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
