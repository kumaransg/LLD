package io.abhishek.machinecoding.splitwise.model;

public class ExactSplit extends Split {

  public ExactSplit(User user, double amount) {
    super(user);
    this.amount = amount;
  }
}
