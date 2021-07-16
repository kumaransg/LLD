package io.abhishek.machinecoding.splitwise.expense;

import io.abhishek.machinecoding.splitwise.model.EqualSplit;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.List;

public class EqualExpense extends Expense {
  public EqualExpense(double amount, User paidBy, List<Split> splits,
      ExpenseMetaData expenseMetaData) {
    super(amount, paidBy, splits, expenseMetaData);
  }

  @Override
  public boolean validate() {
    for(Split split : getSplits()) {
      if (!(split instanceof EqualSplit)) {
        return false;
      }
    }
    return true;
  }
}
