package io.abhishek.machinecoding.splitwise.expense;

import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.List;

public abstract class Expense {
  private String expenseId;
  private double amount;
  private User paidBy;
  private List<Split> splits;
  private ExpenseMetaData expenseMetaData;

  public Expense(double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetaData) {
    this.amount = amount;
    this.paidBy = paidBy;
    this.splits = splits;
    this.expenseMetaData = expenseMetaData;
  }

  public abstract boolean validate();

  public String getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(String expenseId) {
    this.expenseId = expenseId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public User getPaidBy() {
    return paidBy;
  }

  public void setPaidBy(User paidBy) {
    this.paidBy = paidBy;
  }

  public List<Split> getSplits() {
    return splits;
  }

  public void setSplits(List<Split> splits) {
    this.splits = splits;
  }

  public ExpenseMetaData getExpenseMetaData() {
    return expenseMetaData;
  }

  public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
    this.expenseMetaData = expenseMetaData;
  }
}
